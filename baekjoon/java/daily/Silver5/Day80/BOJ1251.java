package Silver5.Day80;

import java.io.*;

public class BOJ1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        String minWord = null;
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String firstPart = new StringBuilder(word.substring(0, i)).reverse().toString();
                String secondPart = new StringBuilder(word.substring(i, j)).reverse().toString();
                String thirdPart = new StringBuilder(word.substring(j)).reverse().toString();

                String newWord = firstPart + secondPart + thirdPart;

                if (minWord == null || newWord.compareTo(minWord) < 0)
                    minWord = newWord;
            }
        }

        bw.write(minWord);

        br.close();
        bw.flush();
        bw.close();
    }
}
