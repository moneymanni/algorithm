package Silver3.Day115;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int first_numerator = Integer.parseInt(st.nextToken());
        int first_denominator = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int second_numerator = Integer.parseInt(st.nextToken());
        int second_denominator = Integer.parseInt(st.nextToken());

        int lcm = lcm(first_denominator, second_denominator);
        int numerator = first_numerator * (lcm / first_denominator)
                + second_numerator * (lcm / second_denominator);

        int gcd = gcd(numerator, lcm);
        numerator /= gcd;
        lcm /= gcd;

        bw.write(String.format("%d %d", numerator, lcm));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
