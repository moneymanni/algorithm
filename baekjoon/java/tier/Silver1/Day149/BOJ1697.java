package Silver1.Day149;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    private static int N, K;
    private static int result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N, K, 100_000);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int start, int end, int high) {
        result = 0;
        visited = new boolean[high + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int node = info[0];
            int cnt = info[1];

            if (node == end) {
                result = cnt;
                return;
            }

            if (node * 2 <= high && !visited[node * 2]) {
                queue.add(new int[]{node * 2, cnt + 1});
                visited[node * 2] = true;
            }
            if (node + 1 <= high && !visited[node + 1]) {
                queue.add(new int[]{node + 1, cnt + 1});
                visited[node + 1] = true;
            }
            if (node - 1 >= 0 && !visited[node - 1]) {
                queue.add(new int[]{node - 1, cnt + 1});
                visited[node - 1] = true;
            }
        }
    }
}
