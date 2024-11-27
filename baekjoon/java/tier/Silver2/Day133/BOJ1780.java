package Silver2.Day133;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1780 {
    private static int minusOne = 0;
    private static int zero = 0;
    private static int plusOne = 0;
    private static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        cutPaper(0, 0, N);

        bw.write(String.format("%d\n%d\n%d", minusOne, zero, plusOne));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cutPaper(int row, int col, int size) {
        if (check(row, col, size)) {
            switch (paper[row][col]) {
                case -1: minusOne++; break;
                case 0: zero++; break;
                case 1: plusOne++; break;
            }

            return;
        }

        int newSize = size / 3;

        cutPaper(row, col, newSize);
        cutPaper(row, col + newSize, newSize);
        cutPaper(row, col + newSize * 2, newSize);

        cutPaper(row + newSize, col, newSize);
        cutPaper(row + newSize, col + newSize, newSize);
        cutPaper(row + newSize, col + newSize * 2, newSize);

        cutPaper(row + newSize * 2, col, newSize);
        cutPaper(row + newSize * 2, col + newSize, newSize);
        cutPaper(row + newSize * 2, col + newSize * 2, newSize);
    }

    private static boolean check(int row, int col, int size) {
        int num = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != num)
                    return false;
            }
        }

        return true;
    }
}
