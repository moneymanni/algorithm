package Silver1.Day155;

import java.io.*;
import java.util.Arrays;

public class BOJ6588 {
    private static final int MAX = 1_000_000;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes(MAX);

        String input;

        StringBuilder sb = new StringBuilder();

        while (!(input = br.readLine()).equals("0")) {
            int num = Integer.parseInt(input);

            boolean isGoldbach = false;

            for (int i = 2; i <= num / 2; i++) {
                if (isPrime[i] && isPrime[num - i]) {
                    sb.append(num).append(" = ").append(i).append(" + ").append(num - i).append('\n');
                    isGoldbach = true;
                    break;
                }
            }

            if (!isGoldbach)
                sb.append("Goldbach's conjecture is wrong.").append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int num) {
        isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);

        if (num >= 0) isPrime[0] = false;
        if (num >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
