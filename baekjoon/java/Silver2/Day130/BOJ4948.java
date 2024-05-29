package Silver2.Day130;

import java.io.*;
import java.util.Arrays;

public class BOJ4948 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);

            isPrime = new boolean[2 * n + 1];
            Arrays.fill(isPrime, true);

            sieveOfEratosthenes(2 * n);

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i])
                    cnt++;
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int n) {
        if (n >= 1)
            isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
