package StepByStep.factorsmultiplesprimes2;

import java.io.*;
import java.util.Arrays;

public class BOJ4948 {

    private static final int MAX_N = 123_456;

    private static boolean[] isPrimeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieveOfEratosthenes(MAX_N * 2);

        String input;

        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);

            int cnt = 0;

            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrimeArr[i]) cnt++;
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
