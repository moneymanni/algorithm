package doIt.day214;

import java.io.*;

public class BOJ1747 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write("2\n");
        } else {
            for (int i = N; ; i++) {
                if (isPalindrome(i) && checkPrime(i)) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String reverseStr = new StringBuilder(str).reverse().toString();

        return str.equals(reverseStr);
    }

    private static boolean checkPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
