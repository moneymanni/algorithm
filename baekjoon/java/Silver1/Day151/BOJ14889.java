package Silver1.Day151;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14889 {
    private static int N;
    private static int min;
    private static int[][] S;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(1, 0);

        bw.write(min + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == N / 2) {
            calculateDiff();

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

    private static void calculateDiff() {
        int start = 0;
        int link = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j])
                    start += S[i][j] + S[j][i];
                else if (!visited[i] && !visited[j])
                    link += S[i][j] + S[j][i];
            }
        }

        int diff = Math.abs(start - link);

        if (diff < min)
            min = diff;
    }
}
