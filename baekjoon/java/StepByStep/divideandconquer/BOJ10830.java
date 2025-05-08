package StepByStep.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10830 {

    private static final int MOD = 1_000;

    private static int N;
    private static long B;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = matrixPow(matrix, B, MOD);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int[][] multiply(int[][] matrixA, int[][] matrixB, int mod) {
        int len = matrixA.length;

        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                    result[i][j] %= mod;
                }
            }
        }

        return result;
    }

    private static int[][] matrixPow(int[][] A, long exp, int mod) {
        int len = A.length;

        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiply(result, A, mod);
            }

            A = multiply(A, A, mod);
            exp /= 2;
        }

        return result;
    }
}
