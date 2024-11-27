package Gold5.Day188;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10835 {

    private static int N;
    private static int[] A, B;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        dp = new int[N][N];

        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        bw.write(recur(0, 0) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int recur(int left, int right) {
        if (left == N || right == N)
            return 0;

        if (dp[left][right] != -1)
            return dp[left][right];

        dp[left][right] = 0;

        int leftResult = recur(left + 1, right);
        int bothResult = recur(left + 1, right + 1);

        int rightResult = 0;

        if (A[left] > B[right])
            rightResult = B[right] + recur(left, right + 1);

        return dp[left][right] = Math.max(leftResult, Math.max(bothResult, rightResult));
    }
}
