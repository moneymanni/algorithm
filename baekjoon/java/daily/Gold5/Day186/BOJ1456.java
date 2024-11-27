package Gold5.Day186;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1456 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        sieveOfEratosthenes((int) Math.sqrt(B) + 1);

        int primeCnt = 0;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                long temp = i;

                while (temp <= (double) B / i) {
                    if (temp >= (double) A / i)
                        primeCnt++;

                    temp *= i;
                }
            }
        }

        bw.write(primeCnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int num) {
        isPrime = new boolean[num + 1];

        Arrays.fill(isPrime, true);

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
