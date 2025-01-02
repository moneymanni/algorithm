package doIt.day213;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1456 {

    private static final int MAX_NUM = 10_000_000;

    private static long A, B;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        sieveOfEratosthenes(MAX_NUM);

        int cnt = 0;

        for (int i = 2; i <= MAX_NUM; i++) {
            if (isPrime[i]) {
                long temp = i;

                while ((double) i <= (double) B / temp) {
                    if ((double) i >= (double) A / temp) {
                        cnt++;
                    }
                    temp *= i;
                }
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int N) {
        isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
