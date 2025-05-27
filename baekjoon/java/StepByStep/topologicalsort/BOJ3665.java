package StepByStep.topologicalsort;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3665 {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String QUESTION = "?";

    private static int testCase, n, m;
    private static int[] grade, indegree;
    private static boolean[][] edges;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());

            grade = new int[n + 1];
            indegree = new int[n + 1];
            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                grade[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                int from = grade[i];

                for (int j = i + 1; j <= n; j++) {
                    int to = grade[j];

                    graph[from].add(to);
                    indegree[to]++;
                }
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a].contains(b)) {
                    graph[a].remove((Integer) b);
                    graph[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b].remove((Integer) a);
                    graph[a].add(b);
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            String result = topologySort();

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                cnt++;
                queue.add(i);
            }
        }

        if (cnt > 1) {
            return QUESTION;
        }


        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) {
                return IMPOSSIBLE;
            }

            int curr = queue.poll();

            sb.append(curr).append(' ');

            for (int next : graph[curr]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return sb.toString();
    }
}
