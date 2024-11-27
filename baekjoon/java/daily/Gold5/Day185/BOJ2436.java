package Gold5.Day185;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        long mul = (long) gcd * lcm;

        int a = 0;
        int b = 0;

        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0 && GCD(i, mul / i) == gcd) {
                a = i;
                b = (int) (mul / i);
            }
        }

        bw.write(String.format("%d %d\n", a, b));

        br.close();
        bw.flush();
        bw.close();
    }

    private static long GCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }
}
