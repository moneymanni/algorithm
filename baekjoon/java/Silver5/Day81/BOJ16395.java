package Silver5.Day81;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 이항 계수
        // C(n, k) = n! / K! * (n - k)!
//        long result = findBinomialCoefficient(n-1, k-1);

        // 파스칼의 삼각형 이용
        int result = findBinomial(n-1, k-1);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findBinomial (int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    public static long findBinomialCoefficient (int n, int k) {
        long denominator = findFactorial(k) * findFactorial(n - k);
        long numerator = findFactorial(n);

        return numerator / denominator;
    }

    public static long findFactorial (int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;

        return result;
    }
}
