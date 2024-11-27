package Silver2.Day145;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11123 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int H, W;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String input = br.readLine();

                for (int j = 0; j < W; j++)
                    map[i][j] = input.charAt(j);
            }

            int cnt = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '#' && !visited[i][j]) {
                        checkFlock(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void checkFlock(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                if (map[nx][ny] == '#' && !visited[nx][ny])
                    checkFlock(nx, ny);
            }
        }
    }
}
