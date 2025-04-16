package StepByStep.factorsmultiplesprimes2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int denominator = lcm(b1, b2);
        int numerator = (a1 * (denominator / b1)) + (a2 * (denominator / b2));

        int gcd = gcd(denominator, numerator);
        denominator /= gcd;
        numerator /= gcd;

        bw.write(String.format("%d %d\n", numerator, denominator));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
