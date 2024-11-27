package Silver1.Day168;

import java.io.*;

public class BOJ1564 {
    private static final long MOD = (long) 1e12;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());

        String result = findFactorial5(N);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static String findFactorial5(long N) {
        long number = 1;

        for (long i = 2; i <= N; i++) {
            number *= i;

            while (number % 10 == 0)
                number /= 10;

            number %= MOD;
        }

        StringBuilder sb = new StringBuilder();

        number %= 100_000;

        int temp = 10_000;

        while (temp > 1) {
            if (number < temp)
                sb.append(0);
            temp /= 10;
        }
        sb.append(number);

        return sb.toString();
    }
}
