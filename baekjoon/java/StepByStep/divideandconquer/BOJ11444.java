package StepByStep.divideandconquer;

import java.io.*;

public class BOJ11444 {

    private static final int MOD = 1_000_000_007;

    private static final long[][] BASE = new long[][]{{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        if (N == 0) {
            bw.write("0\n");
        } else {
            long[][] result = matrixPow(BASE, N - 1);
            bw.write(result[0][0] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long[][] matrixPow(long[][] matrix, long exp) {
        if (exp == 1 || exp == 0) {
            return matrix;
        }

        long[][] half = matrixPow(matrix, exp / 2);
        long[][] result = multiply(half, half);

        if (exp % 2 == 1L) {
            result = multiply(result, BASE);
        }

        return result;
    }

    private static long[][] multiply(long[][] matrixA, long[][] matrixB) {
        long[][] result = new long[2][2];

        result[0][0] = ((matrixA[0][0] * matrixB[0][0]) + (matrixA[0][1] * matrixB[1][0])) % MOD;
        result[0][1] = ((matrixA[0][0] * matrixB[0][1]) + (matrixA[0][1] * matrixB[1][1])) % MOD;
        result[1][0] = ((matrixA[1][0] * matrixB[0][0]) + (matrixA[1][1] * matrixB[1][0])) % MOD;
        result[1][1] = ((matrixA[1][0] * matrixB[0][1]) + (matrixA[1][1] * matrixB[1][1])) % MOD;

        return result;
    }
}
