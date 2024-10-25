package Gold5.Day184;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15661 {
    private static int N;
    private static int minGap;
    private static int[][] S;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        minGap = Integer.MAX_VALUE;
        S = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

        bw.write(minGap + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == N) {
            int teamStart = 0;
            int teamLink = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (visited[i] != visited[j])
                        continue;

                    if (visited[i])
                        teamStart += S[i][j] + S[j][i];
                    else
                        teamLink += S[i][j] + S[j][i];
                }
            }

            int gap = Math.abs(teamStart - teamLink);
            minGap = Math.min(minGap, gap);

            return;
        }

        visited[depth] = true;
        DFS(depth + 1);
        visited[depth] = false;
        DFS(depth + 1);
    }
}
