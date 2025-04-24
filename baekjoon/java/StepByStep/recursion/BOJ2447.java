package StepByStep.recursion;

import java.io.*;

public class BOJ2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] stars = printStar(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(stars[i][j] + "");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static char[][] printStar(int num) {
        char[][] arr = new char[num][num];

        recursion(arr, 0, 0, num, false);

        return arr;
    }

    private static void recursion(char[][] arr, int x, int y, int size, boolean isEmpty) {
        if (isEmpty) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }


        int localSize = size / 3;
        int cnt = 0;

        for (int i = x; i < x + size; i += localSize) {
            for (int j = y; j < y + size; j += localSize) {
                cnt++;

                if (cnt == 5) {
                    recursion(arr, i, j, localSize, true);
                } else {
                    recursion(arr, i, j, localSize, false);
                }
            }
        }
    }
}
