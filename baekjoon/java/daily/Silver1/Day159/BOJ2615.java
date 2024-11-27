package Silver1.Day159;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2615 {
    private static final int LINE_COUNT = 19;
    private static final int WIN_COUNT = 5;
    private static final int[] DX = new int[]{1, 1, 0, -1};
    private static final int[] DY = new int[]{0, 1, 1, 1};
    private static int[][] board;
    private static int[][][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        board = new int[LINE_COUNT + 2][LINE_COUNT + 2];
        temp = new int[LINE_COUNT + 2][LINE_COUNT + 2][DX.length];

        for (int i = 1; i <= LINE_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= LINE_COUNT; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(determineOutcome());

        br.close();
        bw.flush();
        bw.close();
    }

    private static String determineOutcome() {
        for (int j = 1; j <= LINE_COUNT; j++) {
            for (int i = 1; i <= LINE_COUNT; i++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < DX.length; k++) {
                        if (temp[i][j][k] == 0 && check(i, j, k, board[i][j]) == WIN_COUNT)
                            return String.format("%d\n%d %d", board[i][j], i, j);
                    }
                }
            }
        }

        return "0";
    }

    private static int check(int x, int y, int dir, int color) {
        int nx = x + DX[dir];
        int ny = y + DY[dir];

        if (board[nx][ny] == color)
            return temp[nx][ny][dir] = check(nx, ny, dir, color) + 1;

        return 1;
    }
}
