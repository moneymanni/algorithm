package Silver2.Day134;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11722 {
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dynamicProgramming(N);

        int max = Integer.MIN_VALUE;
        for (int i : dp)
            max = Math.max(max, i);

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int N) {
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
}
