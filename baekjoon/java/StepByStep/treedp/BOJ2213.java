package StepByStep.treedp;

import java.io.*;
import java.util.*;

public class BOJ2213 {

    private static int n;
    private static int[][] dp;
    private static boolean[] visited;
    private static int[] nodes;
    private static List<Integer> res;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        nodes = new int[n + 1];
        res = new ArrayList<>();
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        traversal(1);

        if (dp[1][1] > dp[1][0]) {
            bw.write(dp[1][1] + "\n");
            trace(1, 1);
        } else {
            bw.write(dp[1][0] + "\n");
            trace(1, 0);
        }

        Collections.sort(res);

        for (int num : res) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void trace(int pos, int op) {
        visited[pos] = true;

        if (op == 1) {
            res.add(pos);

            for (int next : graph[pos]) {
                if (!visited[next]) {
                    trace(next, 0);
                }
            }
        } else {
            for (int next : graph[pos]) {
                if (!visited[next]) {
                    if (dp[next][1] > dp[next][0]) {
                        trace(next, 1);
                    } else {
                        trace(next, 0);
                    }
                }
            }
        }

        visited[pos] = false;
    }

    private static void traversal(int pos) {
        int childSize = graph[pos].size();

        dp[pos][0] = 0;
        dp[pos][1] = nodes[pos];

        if (childSize == 0) {
            return;
        }

        visited[pos] = true;

        for (int child : graph[pos]) {
            if (!visited[child]) {
                traversal(child);

                if (dp[child][0] > dp[child][1]) {
                    dp[pos][0] += dp[child][0];
                } else {
                    dp[pos][0] += dp[child][1];
                }

                dp[pos][1] += dp[child][0];
            }
        }

        visited[pos] = false;
    }
}
