package Silver2.Day138;

import java.io.*;
import java.util.Arrays;

public class BOJ17103 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes(1_000_000);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int partitionCnt = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) {
                    partitionCnt++;
                }
            }

            bw.write(partitionCnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int num) {
        isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i)
                    isPrime[j] = false;
            }
        }
    }
}
