package Silver1.Day156;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = findGCD(Math.max(a, b), Math.min(a, b));

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= result; i++)
            sb.append('1');

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
