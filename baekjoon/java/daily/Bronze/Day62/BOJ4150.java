package Day62;

import java.io.*;
import java.math.BigInteger;

public class BOJ4150 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        BigInteger result = fibonacci(num);
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static BigInteger fibonacci (int num) {
        if (num <= 1)
            return BigInteger.valueOf(num);

        BigInteger secondPrevNum = BigInteger.ZERO;
        BigInteger firstPrevNum = BigInteger.ONE;
        BigInteger fib = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            fib = secondPrevNum.add(firstPrevNum);
            secondPrevNum = firstPrevNum;
            firstPrevNum = fib;
        }

        return fib;
    }
}
