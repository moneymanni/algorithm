package Silver2.Day129;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1012 {
    private static int N, M, K;
    private static int cnt;
    private static int[][] A;
    private static boolean[][] visited;
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cnt = 0;
            A = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                A[X][Y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && A[i][j] == 1) {
                        DFS(i, j);
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

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int currX = x + dx[i];
            int currY = y + dy[i];

            if (currX >= 0 && currY >= 0 && currX < M && currY < N) {
                if (A[currX][currY] == 1 && !visited[currX][currY])
                    DFS(currX, currY);
            }
        }
    }
}
