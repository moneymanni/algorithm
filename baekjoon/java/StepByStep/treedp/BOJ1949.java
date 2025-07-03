package StepByStep.treedp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1949 {

    private static int N;
    private static int[][] dp;
    private static boolean[] visited;
    private static int[] pueblos;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        pueblos = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pueblos[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        int result = Math.max(traversal(1, 0), traversal(1, 1) + pueblos[1]);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int traversal(int pos, int flag) {
        if (graph[pos].isEmpty()) {
            return 0;
        }
        if (dp[pos][flag] != -1) {
            return dp[pos][flag];
        }

        visited[pos] = true;
        dp[pos][flag] = 0;

        for (int next : graph[pos]) {
            if (!visited[next]) {
                if (flag == 1) {
                    dp[pos][flag] += traversal(next, 0);
                } else {
                    dp[pos][flag] += Math.max(
                            traversal(next, 1) + pueblos[next],
                            traversal(next, 0)
                    );
                }
            }
        }

        visited[pos] = false;

        return dp[pos][flag];
    }

}
