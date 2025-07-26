package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5977 {

    private static final int MAX_N = 100_003;
    private static long INF = Long.MAX_VALUE;

    private static int N, K;
    private static long[] prefixSum = new long[MAX_N];
    private static long[] A = new long[MAX_N];
    private static long[] dp = new long[MAX_N];
    private static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for (int i = 1; i <= N; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - K) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && trans(deque.peekLast()) <= trans(i)) {
                deque.pollLast();
            }

            deque.addLast(i);
            dp[i] = prefixSum[i] + trans(deque.peekFirst());

            if (i <= K) {
                dp[i] = Math.max(dp[i], prefixSum[i]);
            }
        }

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long trans(int i) {
        return dp[i - 1] - prefixSum[i];
    }

}
