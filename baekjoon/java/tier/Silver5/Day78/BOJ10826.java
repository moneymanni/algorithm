package Silver5.Day78;

import java.io.*;
import java.math.BigInteger;

public class BOJ10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        BigInteger num = fibonacci(n);
        bw.write(num + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static BigInteger fibonacci (int n) {
        BigInteger[] nums = new BigInteger[n + 1];

        if (n >= 0) nums[0] = BigInteger.ZERO;
        if (n >= 1) nums[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            nums[i] = nums[i-1].add(nums[i-2]);

        return nums[n];
    }
}
