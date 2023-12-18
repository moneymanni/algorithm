package Day49;

import java.io.*;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();

        char[] charsStr = str.toCharArray();
        int[] alphabets = new int[26];
        for (char ch : charsStr)
            alphabets[ch - 'A']++;

        boolean same = false;
        int maxIdx = 0;
        for (int i = 1; i < alphabets.length; i++) {
            if (alphabets[maxIdx] < alphabets[i]) {
                maxIdx = i;
                same = false;
            } else if (alphabets[maxIdx] == alphabets[i]) {
                same = true;
            }
        }

        if (same)
            bw.write("?");
        else
            bw.write(String.valueOf(Character.toChars(maxIdx + 'A')));

        bw.flush();
        br.close();
        bw.close();
    }
}
