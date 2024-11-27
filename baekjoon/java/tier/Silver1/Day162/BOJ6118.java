package Silver1.Day162;

import java.io.*;
import java.util.*;

public class BOJ6118 {
    private static int N, M;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        map = new TreeMap<>();

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        BFS(1);

        int maxNode = -1;
        int maxDist = Integer.MIN_VALUE;
        int cnt = 1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int node = entry.getKey();
            int dist = entry.getValue();

            if (maxDist < dist) {
                maxNode = node;
                maxDist = dist;
                cnt = 1;
            } else if (maxDist == dist) {
                cnt++;
            }
        }

        bw.write(String.format("%d %d %d", maxNode, maxDist, cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int start) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int node = info[0];
            int dist = info[1];

            map.put(node, dist);

            for (int nextNode : A[node]) {
                if (!visited[nextNode]) {
                    queue.add(new int[]{nextNode, dist + 1});
                    visited[nextNode] = true;
                }
            }
        }
    }
}
