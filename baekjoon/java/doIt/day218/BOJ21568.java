package doIt.day218;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ21568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long gcd = gcd(a, b);

        if (c % gcd != 0) {
            bw.write("-1\n");
        } else {
            int mok = (int) (c / gcd);
            long[] ret = func(a, b);
            bw.write(String.format("%d %d\n", ret[0] * mok, ret[1] * mok));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long[] func(long a, long b) {
        long[] ret = new long[2];

        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }

        long q = a / b;
        long[] v = func(b, a % b);

        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;

        return ret;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
