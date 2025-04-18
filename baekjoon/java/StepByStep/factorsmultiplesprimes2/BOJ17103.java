package StepByStep.factorsmultiplesprimes2;

import java.io.*;
import java.util.Arrays;

public class BOJ17103 {

    private static final int MAX_N = 1_000_000;

    private static boolean[] isPrimeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes(MAX_N);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (isPrimeArr[i] && isPrimeArr[N - i]) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sieveOfEratosthenes(int num) {
        isPrimeArr = new boolean[num + 1];

        Arrays.fill(isPrimeArr, true);

        isPrimeArr[0] = isPrimeArr[1] = false;

        for (int i = 2; i * i <= num; i++) {
            if (isPrimeArr[i]) {
                for (int j = i * i; j <= num; j += i) {
                    isPrimeArr[j] = false;
                }
            }
        }
    }
}
