package Gold5.Day171;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {
    private static final int UNCLEAN_STATE = 0;
    private static final int WALL = 1;
    private static final int CLEAN_STATE = 2;
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int N, M;
    private static int cnt;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        cnt = 0;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        cleanRoom(r, c, d);

        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void cleanRoom(int r, int c, int d) {
        if (map[r][c] == UNCLEAN_STATE)
            cnt++;

        map[r][c] = CLEAN_STATE;

        for (int i = 0; i < DX.length; i++) {
            d = (d + 3) % 4;
            int nx = r + DX[d];
            int ny = c + DY[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == UNCLEAN_STATE) {
                    cleanRoom(nx, ny, d);
                    return;
                }
            }
        }

        int nd = (d + 2) % 4;
        int nx = r + DX[nd];
        int ny = c + DY[nd];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (map[nx][ny] != WALL) {
                cleanRoom(nx, ny, d);
            }
        }
    }
}
