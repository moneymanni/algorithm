package Silver3.Day115;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        BigInteger result = combine(n, m);
//
//        bw.write(result.toString());


        BigInteger sum = BigInteger.ONE;
        BigInteger div = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(n - i)));
            div = div.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        bw.write(sum.divide(div).toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static BigInteger combine(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }

    private static BigInteger factorial(int n) {
        if (n <= 1)
            return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
}
