package StepByStep.baektracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {

    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        DFS(0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
