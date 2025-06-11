package StepByStep.dpandtraceback;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11779 {

    private static final int INF = 100_000_000;

    private static int n, m;
    private static Node[] dp;
    private static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dp = new Node[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = new Node(INF, -1, -1);
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        bw.write(String.format("%d\n%d\n", dp[end].value, dp[end].cnt));

        Stack<Integer> stack = new Stack<>();

        stack.push(end);

        while (dp[stack.peek()].prevNode != -1) {
            stack.push(dp[stack.peek()].prevNode);
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[]{start, 0});
        dp[start] = new Node(0, 1, -1);

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int curr = info[0];

            if (curr == end) break;

            for (Edge next : graph[curr]) {
                if (dp[next.target].value > dp[curr].value + next.cost) {
                    dp[next.target] = new Node(dp[curr].value + next.cost, dp[curr].cnt + 1, curr);
                    pq.add(new int[]{next.target, dp[next.target].value});
                }
            }
        }
    }

    private static class Node {
        int value;
        int cnt;
        int prevNode;

        public Node(int value, int cnt, int prevNode) {
            this.value = value;
            this.cnt = cnt;
            this.prevNode = prevNode;
        }
    }

    private static class Edge {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
