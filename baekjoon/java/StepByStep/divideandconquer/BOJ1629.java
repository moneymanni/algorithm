package StepByStep.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1629 {

    private static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long result = find(A, B, C);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long find(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }

        long half = find(base, exp / 2, mod);
        long halfMod = (half * half) % mod;

        if (exp % 2 != 0) {
            halfMod = (halfMod * base) % mod;
        }

        return halfMod;
    }
}
