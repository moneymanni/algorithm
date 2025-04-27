package StepByStep.baektracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        DFS(1, 0);

        System.out.print(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int v, int depth) {
        if (depth == M) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = v; i <= N; i++) {
            arr[depth] = i;
            DFS(v, depth + 1);
        }
    }
}
