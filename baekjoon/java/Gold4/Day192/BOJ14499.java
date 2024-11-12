package Gold4.Day192;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14499 {

    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {1, -1, 0, 0};
    private static final int[] DICE = new int[7];

    private static int N, M, x, y, K;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            int result = move(dir);

            if (result != -1)
                bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int move(int dir) {
        int nx = x + DX[dir - 1];
        int ny = y + DY[dir - 1];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
            return -1;

        x = nx;
        y = ny;

        return roll(nx, ny, dir);
    }

    private static int roll(int x, int y, int dir) {
        int temp = DICE[3];

        switch (dir) {
            case 1:
                DICE[3] = DICE[4];
                DICE[4] = DICE[6];
                DICE[6] = DICE[2];
                DICE[2] = temp;
                break;
            case 2:
                DICE[3] = DICE[2];
                DICE[2] = DICE[6];
                DICE[6] = DICE[4];
                DICE[4] = temp;
                break;
            case 3:
                DICE[3] = DICE[5];
                DICE[5] = DICE[6];
                DICE[6] = DICE[1];
                DICE[1] = temp;
                break;
            case 4:
                DICE[3] = DICE[1];
                DICE[1] = DICE[6];
                DICE[6] = DICE[5];
                DICE[5] = temp;
                break;
        }

        if (map[x][y] == 0) {
            map[x][y] = DICE[6];
        } else {
            DICE[6] = map[x][y];
            map[x][y] = 0;
        }

        return DICE[3];
    }
}
