package Day40;

import java.io.*;

public class BOJ2789 {
    public static final String BANNED_WORD = "CAMBRIDGE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        char[] bannedAlphabets = BANNED_WORD.toCharArray();
        char[] charsWord = word.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charsWord.length; i++) {
            boolean isBanned = false;
            for (int j = 0; j < bannedAlphabets.length; j++) {
                if (charsWord[i] == bannedAlphabets[j])
                    isBanned = true;
            }
            if (!isBanned)
                sb.append(charsWord[i]);
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
