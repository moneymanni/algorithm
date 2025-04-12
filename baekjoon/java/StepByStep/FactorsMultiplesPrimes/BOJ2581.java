package StepByStep.FactorsMultiplesPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2581 {

    private static final int MAX_NUM = 10_000;

    private static boolean[] primesArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = MAX_NUM + 1;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.printf("%d\n%d\n", sum, min);
        }

        br.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void sieveOfEratosthenes(int num) {
        primesArr = new boolean[num + 1];

        for (int i = 2; i <= num; i++) {
            primesArr[i] = true;
        }

        for (int i = 2; i * i <= num; i++) {
            if (primesArr[i]) {
                for (int j = i * i; j <= num; j += i) {
                    primesArr[j] = false;
                }
            }
        }
    }
}
