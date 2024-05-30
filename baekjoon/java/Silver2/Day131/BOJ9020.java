package Silver2.Day131;

import java.io.*;
import java.util.Arrays;

public class BOJ9020 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        isPrime = new boolean[10_001];
        Arrays.fill(isPrime, true);

        sieveOfEratosthenes(10_000);

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int p = n / 2, q = n / 2;

            while (true) {
                if (isPrime[p] && isPrime[q]) {
                    sb.append(p).append(' ').append(q).append('\n');
                    break;
                }
                p--;
                q++;
            }
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    static void sieveOfEratosthenes(int num) {
        if (num >= 1)
            isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
