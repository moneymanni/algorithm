package Silver1.Day164;

import java.io.*;
import java.util.*;

public class BOJ4883 {
    private static int N;
    private static int[][] graph;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input;
        int idx = 1;

        while (!(input = br.readLine()).equals("0")) {
            N = Integer.parseInt(input);

            graph = new int[N + 1][4];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= 3; j++)
                    graph[i][j] = Integer.parseInt(st.nextToken());
            }

            findShortestPath();

            sb.append(idx++).append(". ").append(dp[N][2]).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void findShortestPath() {
        dp = new int[N + 1][4];

        dp[1][1] = Integer.MAX_VALUE;
        dp[1][2] = graph[1][2];
        dp[1][3] = graph[1][3] + graph[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][1] = graph[i][1] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][2] = graph[i][2] + Math.min(Math.min(dp[i][1], dp[i-1][1]), Math.min(dp[i-1][2], dp[i-1][3]));
            dp[i][3] = graph[i][3] + Math.min(dp[i][2], Math.min(dp[i-1][2], dp[i-1][3]));
        }
    }
}
