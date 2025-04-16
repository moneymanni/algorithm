package StepByStep.factorsmultiplesprimes2;

import java.io.*;

public class BOJ4134 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long num = Long.parseLong(br.readLine());

            for (long i = num; ; i++) {
                if (isPrime(i)) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
