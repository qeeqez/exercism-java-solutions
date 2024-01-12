public class PopCount {

    /**
     * <b>Straightforward solution:</b>
     * <pre>return Integer.bitCount(number);</pre>
     * <p></p>
     * <b>Alternative solution:</b>
     * <pre>return (int) Integer.toBinaryString(number).chars().filter(c -> c == '1').count();</pre>
     */
    public int eggCount(int number) {
        return (int) manualIntToBinary(number).chars().filter(c -> c == '1').count();
    }

    private String manualIntToBinary(int number) {
        StringBuilder binary = new StringBuilder();

        while (number != 0) {
            binary.append(number % 2);
            number /= 2;
        }

        return binary.toString();
    }
}
