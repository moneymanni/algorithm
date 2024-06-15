package Silver2.Day142;

import java.io.*;

public class BOJ1254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int answer = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i)))
                break;
            answer++;
        }

        bw.write(answer + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
