package StepByStep.graphandtraversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100_000;

    private static int N, K;
    private static int minCnt;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        minCnt = 0;
        visited = new boolean[MAX_RANGE + 1];

        BFS(N, K);

        bw.write(minCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int cnt = curr[1];

            if (node == end) {
                minCnt = cnt;
            }

            if (node * 2 <= MAX_RANGE && !visited[node * 2]) {
                queue.add(new int[]{node * 2, cnt + 1});
                visited[node * 2] = true;
            }
            if (node + 1 <= MAX_RANGE && !visited[node + 1]) {
                queue.add(new int[]{node + 1, cnt + 1});
                visited[node + 1] = true;
            }
            if (node - 1 >= MIN_RANGE && !visited[node - 1]) {
                queue.add(new int[]{node - 1, cnt + 1});
                visited[node - 1] = true;
            }
        }
    }
}
