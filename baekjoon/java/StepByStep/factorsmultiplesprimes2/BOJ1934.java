package StepByStep.factorsmultiplesprimes2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(lcm(a, b) + "\n");
        }

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
