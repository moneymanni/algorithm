package StepByStep.dpandtraceback;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {

    private static int N;
    private static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt = Math.max(cnt, dp[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int len = cnt;

        for (int i = N - 1; i >= 0; i--) {
            if (len == dp[i]) {
                stack.push(A[i]);
                len--;
            }
        }

        bw.write(cnt + "\n");

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
