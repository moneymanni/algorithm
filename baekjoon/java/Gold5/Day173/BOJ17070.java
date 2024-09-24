package Gold5.Day173;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17070 {
    private static int N;
    private static int result;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        result = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(1, 2, 0);  // 0: 가로, 1: 대각선, 2: 세로

        bw.write(String.valueOf(result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int x, int y, int dir) {
        if (x == N && y == N) {
            result++;
            return;
        }

        if (dir == 0 || dir == 1) {
            if (y + 1 <= N && map[x][y + 1] == 0)
                DFS(x, y + 1, 0);
        }

        if (dir == 2 || dir == 1) {
            if (x + 1 <= N && map[x + 1][y] == 0)
                DFS(x + 1, y, 2);
        }

        if (x + 1 <= N && y + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0)
            DFS(x + 1, y + 1, 1);
    }
}
