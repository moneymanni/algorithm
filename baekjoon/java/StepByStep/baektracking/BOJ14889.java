package StepByStep.baektracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14889 {

    private static int N;
    private static int min;
    private static boolean[] visited;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 0);

        bw.write(min + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == N / 2) {
            min = Math.min(min, getDiff());
            return;
        }

        for (int i = v; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int getDiff() {
        int start = 0;
        int link = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    start += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }
}
