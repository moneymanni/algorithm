package StepByStep.FactorsMultiplesPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11653 {

    private static final int N_MAX_NUM = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> factors = factorizeIntoPrimes(N);

        for (Integer factor : factors) {
            System.out.println(factor);
        }

        br.close();
    }

    private static List<Integer> factorizeIntoPrimes(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        if (num != 1) {
            factors.add(num);
        }

        factors.sort(Integer::compareTo);

        return factors;
    }
}
