package StepByStep.FactorsMultiplesPrimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9506 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;

        while ((n = Integer.parseInt(br.readLine())) != -1) {
            List<Integer> list = getFactors(n);

            int sum = list.stream().mapToInt(Integer::intValue).sum() - n;

            if (sum == n) {
                StringBuilder sb = new StringBuilder();
                sb.append(n).append(" = ").append(1);

                for (int i = 1; i < list.size() - 1; i++) {
                    sb.append(" + ").append(list.get(i));
                }

                System.out.println(sb);
            } else {
                System.out.printf("%d is NOT perfect.\n", n);
            }
        }

        br.close();
    }

    private static List<Integer> getFactors(int n) {
        ArrayList<Integer> fators = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                fators.add(i);

                if (i != n / i) {
                    fators.add(n / i);
                }
            }
        }

        fators.sort(Integer::compareTo);

        return fators;
    }
}
