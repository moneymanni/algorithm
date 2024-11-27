package Silver2.Day144;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14620 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N;
    private static int min, sum;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        min = Integer.MAX_VALUE;
        sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(1, 1, 0);

        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int depth) {
        if (depth == 3) {
            min = Math.min(min, sum);

            return;
        }

        for (int i = x; i < N - 1; i++) {
            for (int j = (i == x ? y : 1); j < N - 1; j++) {

                if (check(i, j)) {
                    isFlowerInBloom(i, j, true);

                    DFS(i, j + 2, depth + 1);

                    isFlowerInBloom(i, j, false);
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        if (visited[x][y])
            return false;

        for (int i = 0; i < DX.length; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (visited[nx][ny])
                    return false;
            }
        }

        return true;
    }

    private static void isFlowerInBloom(int x, int y, boolean hasFlowerBloomed) {
        if (hasFlowerBloomed)
            sum += map[x][y];
        else
            sum -= map[x][y];

        visited[x][y] = hasFlowerBloomed;

        for (int k = 0; k < DX.length; k++) {
            int nx = x + DX[k];
            int ny = y + DY[k];

            visited[nx][ny] = hasFlowerBloomed;

            if (hasFlowerBloomed)
                sum += map[nx][ny];
            else
                sum -= map[nx][ny];
        }
    }
}
