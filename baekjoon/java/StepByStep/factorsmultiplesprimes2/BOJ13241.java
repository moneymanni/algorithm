package StepByStep.factorsmultiplesprimes2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        bw.write(lcm(A, B) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
