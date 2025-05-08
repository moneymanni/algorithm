package StepByStep.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11401 {

    private static final int MOD = 1_000_000_007;

    private static int N, K;
    private static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        getFactorial(N);

        long result = (factorial[N] * modInverse(factorial[K])) % MOD;
        result = (result * modInverse(factorial[N - K])) % MOD;

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private static long pow(long base, int exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    private static void getFactorial(int N) {
        factorial = new long[N + 1];

        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }
    }
}
