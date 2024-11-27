package Silver2.Day143;

import java.io.*;

public class BOJ2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Word[] words = new Word[N];

        for (int i = 0; i < N; i++)
            words[i] = new Word(br.readLine());

        int cnt = 0;

        for (int i = 1; i < N; i++) {
            if (words[0].isSimilarWord(words[i]))
                cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Word {
        String word;
        int[] alphabets = new int[26];

        public Word(String word) {
            this.word = word;

            for (int i = 0; i < word.length(); i++)
                alphabets[word.charAt(i) - 'A']++;
        }

        public boolean isSimilarWord(Word o) {
            int plusGap = 0;
            int minusGap = 0;

            for (int i = 0; i < alphabets.length; i++) {
                int diff = alphabets[i] - o.alphabets[i];

                if (diff > 0) plusGap += diff;
                else if (diff < 0) minusGap -= diff;
            }

            return (plusGap == 0 && minusGap == 0) ||
                    (plusGap == 1 && minusGap == 0) ||
                    (plusGap == 0 && minusGap == 1) ||
                    (plusGap == 1 && minusGap == 1);
        }
    }
}
