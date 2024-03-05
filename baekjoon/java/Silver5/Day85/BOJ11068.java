package Silver5.Day85;

import java.io.*;
import java.math.BigInteger;

public class BOJ11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        for (int i = 0; i < T; i++)
            testCase[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = testCase[i];
            boolean isPalindromicNum = false;

            for (int j = 2; j <= 64; j++) {
                String numStr = toBase(num, j);
                String revNumStr = new StringBuilder(numStr).reverse().toString();

                if (numStr.equals(revNumStr)) {
                    isPalindromicNum = true;
                    break;
                }
            }

            bw.write(isPalindromicNum ? "1\n" : "0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static String toBase (int num, int radix) {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(characters.charAt(num % radix));
            num /= radix;
        }

        return sb.reverse().toString();
    }
}
