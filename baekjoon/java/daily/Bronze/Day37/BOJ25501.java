package Day37;

import java.io.*;

public class BOJ25501 {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] testCase = new String[T];
        for (int i = 0; i < T; i++)
            testCase[i] = br.readLine();

        for (int i = 0; i < T; i++) {
            result = 0;
            bw.write(String.format("%d %d\n", isPalindrome(testCase[i]), result));
        }

        br.close();
        bw.close();
    }

    public static int recursion (String s, int l, int r) {
        result++;
        if (l >= r)
            return 1;
        else if (s.charAt(l) != s.charAt(r))
            return 0;
        else
            return recursion(s, l+1, r-1);
    }

    public static int isPalindrome (String s) {
        return recursion(s, 0, s.length()-1);
    }
}
