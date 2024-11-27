package Silver2.Day145;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = perform222Polling(matrix);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int perform222Polling(int[][] matrix) {
        int len = matrix.length;

        if (len == 1)
            return matrix[0][0];

        int newSize = len / 2;

        int[][] newMatrix = new int[newSize][newSize];

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                int[][] subMatrix = splitMatrix(matrix, i * 2, j * 2, 2);
                newMatrix[i][j] = findSecondMaxInMatrix(subMatrix);
            }
        }

        return perform222Polling(newMatrix);
    }

    private static int[][] splitMatrix(int[][] matrix, int startRow, int startCol, int size) {
        int[][] subMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                subMatrix[i][j] = matrix[startRow + i][startCol + j];
            }
        }

        return subMatrix;
    }

    private static int findSecondMaxInMatrix(int[][] matrix) {
        int len = matrix.length;
        int idx = 0;
        int[] elements = new int[len * len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                elements[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(elements);

        return elements[(len * len) - 2];
    }
}
