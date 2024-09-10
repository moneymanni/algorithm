package Silver1.Day168;

import java.io.*;

public class BOJ1283 {
    private static boolean[] alphabets = alphabets = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String str = br.readLine();

            sb.append(setShortcutKey(str)).append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static String setShortcutKey(String str) {
        // 1. 단어의 첫글자
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            char ch = words[i].toLowerCase().charAt(0);

            if (Character.isLetter(ch) && !alphabets[ch - 'a']) {
                words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                alphabets[ch - 'a'] = true;
                return String.join(" ", words);
            }
        }

        // 2. 차례대로
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.toLowerCase().charAt(i);

            if (Character.isLetter(ch) && !alphabets[ch - 'a']) {
                sb.append('[').append(str.charAt(i)).append(']');
                alphabets[ch - 'a'] = true;
                for (int j = i + 1; j < str.length(); j++) sb.append(str.charAt(j));
                break;
            }

            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
