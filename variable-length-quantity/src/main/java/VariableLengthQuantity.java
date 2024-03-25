import java.util.LinkedList;
import java.util.List;

/**
 * VLQ encoding/decoding
 *
 * @see <a href="https://en.wikipedia.org/wiki/Variable-length_quantity">Wikipedia</a>
 */
class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {
        return numbers.stream().map(this::encode).flatMap(List::stream).toList();
    }

    List<String> encode(Long number) {
        List<String> output = new LinkedList<>();

        String binary = Long.toBinaryString(number);
        for (int i = binary.length(); i > 0; i -= 7) {
            int j = Math.max(0, i - 7);
            long sevenBits = Long.parseLong(binary.substring(j, i), 2);
            if (i != binary.length()) sevenBits += 1 << 7;
            output.addFirst(binaryToHex(sevenBits));
        }

        return output;
    }

    List<String> decode(List<Long> bytes) {
        if (bytes.getLast() >= 1 << 7) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        List<String> result = new LinkedList<>();

        long value = 0;
        for (Long b : bytes) {
            value = (value << 7) | (b & 0x7F);
            if ((b & 0x80) == 0) {
                result.add(binaryToHex(value));
                value = 0;
            }
        }
        return result;
    }

    private String binaryToHex(long binary) {
        return "0x" + Long.toHexString(binary);
    }
}
