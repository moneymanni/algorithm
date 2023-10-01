package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());

        System.out.println(factorial(1, N));
    }
    public static BigInteger factorial(int a, int num) {
        BigInteger ret = BigInteger.valueOf(a);

        if (num <= a)
            return ret;
        int b = (a + num) / 2;
        return ret = factorial(a, b).multiply(factorial(b+1, num));
    }
}
