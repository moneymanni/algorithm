package Silver1.Day165;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {
    private static int A, B, N, M;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[100_001];
        visited = new boolean[100_001];

        BFS(N);

        bw.write(Integer.toString(arr[M]));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.remove();

            int[] temp = {node - 1, node + 1, node - A, node + A, node - B, node + B, node * A, node * B};

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] >= 0 && temp[i] <= 100_000 && !visited[temp[i]]) {
                    visited[temp[i]] = true;
                    arr[temp[i]] = arr[node] + 1;
                    queue.add(temp[i]);
                }
            }

            if (arr[M] > 0) break;
        }
    }
}
