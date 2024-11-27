package Silver1.Day150;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1932 {
    private static int N;
    private static int[][] arr;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++)
            dp[N - 1][i] = arr[N - 1][i];

        bw.write(find(0, 0) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int find(int depth, int idx) {
        if(depth == N - 1)
            return dp[depth][idx];

        if (dp[depth][idx] == null)
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];

        return dp[depth][idx];
    }
}
