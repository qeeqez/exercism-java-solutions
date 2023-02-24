public class PascalsTriangleGenerator {

    public int[][] generateTriangle(int numRows) {
        int[][] output = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            output[i] = new int[i + 1];
            output[i][0] = 1;
            output[i][i] = 1;
            for (int j = 1; j < i; j++) {
                output[i][j] = output[i - 1][j - 1] + output[i - 1][j];
            }
        }
        return output;
    }
}