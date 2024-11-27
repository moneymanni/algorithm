package Day53;

import java.io.*;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String result = encryptStrIntoROT13(S);
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static String encryptStrIntoROT13 (String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char chROT13 = (char) (ch + 13);

            if (('0' <= ch && ch <= '9') || ch == ' ') {
                sb.append(ch);
                continue;
            }

            if (('a' <= ch && ch <= 'z') && chROT13 > 'z') {
                chROT13 = (char) ('a' + chROT13 - 'z' - 1);
            } else if (('A' <= ch && ch <= 'Z') && chROT13 > 'Z') {
                chROT13 = (char) ('A' + chROT13 - 'Z' - 1);
            }
            sb.append(chROT13);
        }

        return sb.toString();
    }
}
