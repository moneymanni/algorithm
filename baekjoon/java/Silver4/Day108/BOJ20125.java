package Silver4.Day108;

import java.io.*;

public class BOJ20125 {
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        board = new boolean[N+2][N+2];
        int[] heartPos = new int[2];  // heartPos[0] : x축, heartPos[1] : y축
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                char ch = line.charAt(j-1);
                if (ch == '*') {
                    board[i][j] = true;
                    if (heartPos[0] == 0 && heartPos[1] == 0) {
                        heartPos[0] = j;
                        heartPos[1] = i + 1;
                    }
                }
            }
        }

        int[] cookie = new int[5];  // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리
        int[] dx = new int[]{-1, 1, 0, 0, 0};
        int[] dy = new int[]{0, 0, 1, 1, 1};
        int tx = heartPos[0];
        int ty = heartPos[1];

        cookie[0] = measureLen(tx-1, ty, dx[0], dy[0]);
        cookie[1] = measureLen(tx+1, ty, dx[1], dy[1]);
        cookie[2] = measureLen(tx, ty+1, dx[2], dy[2]);
        ty += cookie[2];
        cookie[3] = measureLen(tx-1, ty+1, dx[3], dy[3]);
        cookie[4] = measureLen(tx+1, ty+1, dx[4], dy[4]);

        bw.write(String.format("%d %d\n", heartPos[1], heartPos[0]));
        for (int len : cookie)
            bw.write(len + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    static int measureLen (int x, int y, int dx, int dy) {
        int len = 0;

        while (board[y][x]) {
            len++;
            x += dx;
            y += dy;
        }

        return len;
    }
}
