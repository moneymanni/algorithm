package StepByStep.treedp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2533 {

    private static int N;
    private static int[][] dp;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = Math.min(
                earlyAdaptor(1, 0, -1),
                earlyAdaptor(1, 1, -1)
        );

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int earlyAdaptor(int node, int isAdaptor, int parent) {
        if (graph[node].isEmpty()) {
            return 0;
        }

        if (dp[node][isAdaptor] != -1) {
            return dp[node][isAdaptor];
        }

        int sum = 0;

        for (int child : graph[node]) {
            if (child != parent) {
                if (isAdaptor == 1) {
                    sum += Math.min(
                            earlyAdaptor(child, 0, node),
                            earlyAdaptor(child, 1, node)
                    );
                } else {
                    sum += earlyAdaptor(child, 1, node);
                }
            }
        }

        dp[node][isAdaptor] = sum + isAdaptor;

        return dp[node][isAdaptor];
    }

}
