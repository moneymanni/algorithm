package Gold4.Day194;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {

    private static int N;
    private static int[] A;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++)
            cnt = Math.max(cnt, dp[i]);

        Stack<Integer> stack = new Stack<>();
        int len = cnt;

        for (int i = N; i >= 1; i--) {
            if (len == dp[i]) {
                stack.push(A[i]);
                len--;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append('\n');

        while (!stack.isEmpty())
            sb.append(stack.pop()).append(' ');

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
