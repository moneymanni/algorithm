package Silver3.Day111;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        DFS(0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int val : arr)
                sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            DFS(depth + 1);
        }
    }
}
