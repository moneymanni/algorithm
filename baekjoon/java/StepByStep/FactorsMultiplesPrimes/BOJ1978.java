package StepByStep.FactorsMultiplesPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1978 {

    private static final int MAX_NUM = 1_000;

    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sieveOfEratosthenes(MAX_NUM);

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (prime(num)) cnt++;
//            if (isPrime[num]) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    private static boolean prime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void sieveOfEratosthenes(int num) {
        isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
