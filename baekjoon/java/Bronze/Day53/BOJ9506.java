package Day53;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BOJ9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            List<Integer> factors = findDivisors(n);

            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for (int factor : factors) {
                sum += factor;
                sb.append(factor).append(" + ");
            }
            sb.delete(sb.length() - 3, sb.length());

            if (n == sum) {
                bw.write(String.format("%d = %s", n, sb));
            } else {
                bw.write(String.format("%d is NOT perfect.", n));
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static List<Integer> findDivisors (int num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisors.add(i);

                if (num / i != i && num / i != num)
                    divisors.add(num / i);
            }
        }

        divisors.sort(Comparator.naturalOrder());

        return divisors;
    }
}
