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
            output.addFirst("0x" + Long.toHexString(sevenBits));
        }

        return output;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
