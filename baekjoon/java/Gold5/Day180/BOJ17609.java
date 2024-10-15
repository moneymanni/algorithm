package Gold5.Day180;

import java.io.*;

public class BOJ17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();

            bw.write(checkPalindrome(str) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int checkPalindrome(String str) {
        StringBuilder reverseSb = new StringBuilder(str).reverse();

        if (str.equals(reverseSb.toString()))
            return 0;

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                StringBuilder delLeft = new StringBuilder(str).deleteCharAt(start);
                StringBuilder delRight = new StringBuilder(str).deleteCharAt(end);

                if (delLeft.toString().equals(delLeft.reverse().toString())
                        || delRight.toString().equals(delRight.reverse().toString()))
                    return 1;
                break;
            }

            start++;
            end--;
        }

        return 2;
    }
}
