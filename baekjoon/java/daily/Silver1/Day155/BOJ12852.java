package Silver1.Day155;

import java.io.*;

public class BOJ12852 {
    private static int[] dp;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamicProgramming(N);

        StringBuilder sb = new StringBuilder();
        int num = N;

        while (num > 0) {
            sb.append(num).append(' ');
            num = arr[num];
        }

        bw.write(String.format("%d\n%s", dp[N], sb.toString().trim()));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dynamicProgramming(int num) {
        dp = new int[num + 1];
        arr = new int[num + 1];

        dp[1] = 0;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            arr[i] = i - 1;

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                arr[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                arr[i] = i / 2;
            }
        }
    }
}
