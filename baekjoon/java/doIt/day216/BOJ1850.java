package doIt.day216;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = gcd(A, B);

        while (result-- > 0) {
            bw.write("1");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
