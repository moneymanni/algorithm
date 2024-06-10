package Silver2.Day139;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2961 {
    private static int N;
    private static int M;
    private static int gap = Integer.MAX_VALUE;
    private static int[][] A, arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N][2];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            M = i;
            arr = new int[i][2];

            DFS(0, 0);
        }

        bw.write(gap + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == M) {
            int A = 1;
            int B = 0;
            for (int i = 0; i < M; i++) {
                A *= arr[i][0];
                B += arr[i][1];
            }

            gap = Math.min(gap, Math.abs(A - B));

            return;
        }

        for (int i = v; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth][0] = A[i][0];
                arr[depth][1] = A[i][1];
                DFS(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
