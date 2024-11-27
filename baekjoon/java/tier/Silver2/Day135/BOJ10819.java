package Silver2.Day135;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10819 {
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static int[] A, arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        DFS(0);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;

            for (int i = 1; i < N; i++)
                sum += Math.abs(arr[i - 1] - arr[i]);

            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = A[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
