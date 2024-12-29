package doit.day215;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1016 {

    private static long min, max;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        findNoneSqrtNum();

        int cnt = 0;

        for (int i = 0; i <= max - min; i++) {
            if (isPrime[i]) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void findNoneSqrtNum() {
        isPrime = new boolean[(int) (max - min + 1)];

        Arrays.fill(isPrime, true);

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIdx = min / pow;

            if (min % pow != 0) startIdx++;

            for (long j = startIdx; pow * j <= max; j++) {
                isPrime[(int) (j * pow - min)] = false;
            }
        }
    }
}
