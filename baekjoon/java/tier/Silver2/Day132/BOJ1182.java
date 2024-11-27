package Silver2.Day132;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static int N, S;
    private static int[] arr;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        DFS(0, 0);

        if (S == 0)
            bw.write(result - 1 + "");
        else
            bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S)
                result++;
            return;
        }

        DFS(depth  + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}
