package Silver1.Day151;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        bw.write(find(A, B, C) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long find(long base, long exponent, long mod) {
        if (exponent == 0)
            return 1;

        long half = find(base, exponent / 2, mod);
        long halfMod = (half * half) % mod;

        if (exponent % 2 != 0)
            halfMod = (halfMod * base) % mod;

        return halfMod;
    }
}
