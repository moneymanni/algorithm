package Silver5.Day75;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 유클리드 호제법을 이용
        long gcd = gcd(A, B);
        long lcm = A * B / gcd;

        bw.write(lcm + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long gcd (long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
