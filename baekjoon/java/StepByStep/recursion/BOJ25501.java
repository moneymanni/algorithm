package StepByStep.recursion;

import java.io.*;

public class BOJ25501 {

    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String S = br.readLine();

            cnt = 0;
            boolean palindromeStatus = isPalindrome(S, 0, S.length() - 1);

            bw.write(String.format("%d %d\n", palindromeStatus ? 1 : 0, cnt));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrome(String str, int start, int end) {
        cnt++;

        if (start >= end) {
            return true;
        } else if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}
