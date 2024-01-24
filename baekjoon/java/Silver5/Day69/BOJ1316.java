package Silver5.Day69;

import java.io.*;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] testCase = new String[N];
        for (int i = 0; i < N; i++)
            testCase[i] = br.readLine();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean isGroupWord = checkGroupWord(testCase[i]);

            if (isGroupWord)
                cnt++;
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean checkGroupWord (String str) {
        boolean[] alphabets = new boolean[26];
        int len = str.length();

        char prev = str.charAt(0);
        for (int i = 1; i < len; i++) {
            char ch = str.charAt(i);

            if (alphabets[ch - 'a'])
                return false;
            if (prev != ch)
                alphabets[prev - 'a'] = true;

            prev = ch;
        }

        return true;
    }
}
