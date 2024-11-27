package Silver3.Day110;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        DFS(1, 0);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void DFS(int at, int depth) {
        if (depth == M) {
            for (int val : arr)
                sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            DFS(i + 1, depth + 1);
        }
    }
}
