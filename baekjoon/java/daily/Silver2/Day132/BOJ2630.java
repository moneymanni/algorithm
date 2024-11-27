package Silver2.Day132;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        partition(0, 0, N);

        bw.write(white + "\n" + blue);

        br.close();
        bw.flush();
        bw.close();
    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (map[row][col] == 0)
                white++;
            else
                blue++;

            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    private static boolean check(int row, int col, int size) {
        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color)
                    return false;
            }
        }

        return true;
    }
}
