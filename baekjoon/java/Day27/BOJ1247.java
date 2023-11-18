package Day27;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class BOJ1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger[] nums = new BigInteger[N];
            for (int j = 0; j < N; j++)
                nums[j] = new BigInteger(br.readLine());

            BigInteger sum = Arrays.stream(nums).reduce(BigInteger.ZERO, BigInteger::add);
            String result = sum.toString();

            switch (result.charAt(0)) {
                case '0':
                    bw.write("0\n");
                    break;
                case '-':
                    bw.write("-\n");
                    break;
                default:
                    bw.write("+\n");
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
