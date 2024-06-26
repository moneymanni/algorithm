package Silver2.Day148;

import java.io.*;

public class BOJ2725 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        countPoints(1000);

        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (C-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void countPoints(int N) {
        dp = new int[N + 1];

        if (N >= 1) dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            int cnt = 0;

            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1)
                    cnt += 2;
            }

            dp[i] = dp[i - 1] + cnt;
        }
    }

    // 최대 공약수를 구하는 메서드(유클리드 호제법)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
