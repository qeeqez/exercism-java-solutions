public class SquareRoot {
    public int squareRoot(int radicand) {
        int c = 0;
        int d = Integer.MAX_VALUE / 2 + 1;

        while (d != 0) {
            if (radicand >= c + d) {
                radicand -= c + d;
                c = (c >> 1) + d;
            } else {
                c >>= 1;
            }
            d >>= 2;
        }

        return c;
    }

    @SuppressWarnings("unused")
    public float squareRootApproximate(float z) {
        int bits = Float.floatToIntBits(z);
        bits -= 1 << 23;
        bits >>= 1;
        bits += 1 << 29;
        return Float.intBitsToFloat(bits);
    }
}
