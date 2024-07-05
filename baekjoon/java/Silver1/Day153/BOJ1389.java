package Silver1.Day153;

import java.io.*;
import java.util.*;

public class BOJ1389 {
    private static int N, M;
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        int minValue = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 1; i <= N; i++) {
            int sum = BFS(i);

            if (sum < minValue) {
                minValue = sum;
                minIdx = i;
            } else if (sum == minValue && i < minIdx) {
                minIdx = i;
            }
        }

        bw.write(minIdx + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(int v) {
        visited = new boolean[N + 1];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{v, 0});
        visited[v] = true;

        int sum = 0;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int node = info[0];
            int cnt = info[1];

            sum += cnt;

            for (int i : A[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, cnt + 1});
                }
            }
        }

        return sum;
    }
}
