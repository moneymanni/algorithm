package Day40;

import java.io.*;

public class BOJ5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String wordCaesar = br.readLine();

        char[] charsWord = wordCaesar.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char ch : charsWord) {
            if ('A' <= ch && ch <= 'C') {
                sb.append((char)((ch - 'A') + 'X'));
            } else {
                sb.append((char)(ch - 3));
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
