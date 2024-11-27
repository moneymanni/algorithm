package Silver1.Day157;

import java.io.*;

public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("2");
        } else {
            for (int i = N; ; i++) {
                if (isPalindrome(i) && isPrime(i)) {
                    bw.write(i + "");
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrome(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();

        for (int i = 0; i <= len / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(len - 1 - i))
                return false;
        }

        return true;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
