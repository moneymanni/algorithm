package Silver1.Day167;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2824 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        BigInteger A = new BigInteger("1");

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A = A.multiply(new BigInteger(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        BigInteger B = new BigInteger("1");

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
           B = B.multiply(new BigInteger(st.nextToken()));

        String result = getGCD(A, B).toString();

        if (result.length() > 9)
            result = result.substring(result.length() - 9);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    private static BigInteger getGCD(BigInteger a, BigInteger b) {
        while (b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger temp = b;
            b = a.remainder(b);
            a = temp;
        }

        return a;
    }
}
