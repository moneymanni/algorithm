package Silver2.Day145;

import java.io.*;
import java.util.Arrays;

public class BOJ15965 {
    private static final int LAST_NUMBER = 7_368_787;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        // 8_000_000
        sieveOfEratosthenes(LAST_NUMBER);

        for (int i = 2; i <= LAST_NUMBER; i++) {
            if (isPrime[i]) {
                if (--K == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }

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
