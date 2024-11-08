package Gold4.Day190;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1987 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int R, C;
    private static int max;
    private static boolean[] alphabets;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabets = new boolean[26];
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++)
                board[i][j] = input.charAt(j) - 'A';
        }

        DFS(0, 0, 1);

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int depth) {
        alphabets[board[x][y]] = true;
        max = Math.max(max, depth);

        for (int k = 0; k < DX.length; k++) {
            int nx = x + DX[k];
            int ny = y + DY[k];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!alphabets[board[nx][ny]]) {
                    DFS(nx, ny, depth + 1);
                    alphabets[board[nx][ny]] = false;
                }
            }
        }
    }
}
