package StepByStep.twopointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1644 {

    private static final int MAX_NUM = 4_000_000;

    private static int N;
    private static boolean[] isPrime;
    private static ArrayList<Integer> primes = new ArrayList<>();
    private static ArrayList<Integer> prefixSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        sieveOfEratosthenes(MAX_NUM);

        primes.add(0);
        prefixSum.add(0);

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        for (int i = 1; i < primes.size(); i++) {
            prefixSum.add(prefixSum.get(i - 1) + primes.get(i));
        }

        int cnt = 0;
        int startIdx = 0, endIdx = 0;

        while (startIdx <= endIdx && endIdx < primes.size()) {
            int sum = prefixSum.get(endIdx) - prefixSum.get(startIdx);

            if (sum == N) {
                cnt++;
            }

            if (sum >= N) {
                startIdx++;
            } else {
                endIdx++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int limit) {
        isPrime = new boolean[limit + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
