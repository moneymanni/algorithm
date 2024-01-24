package Day30;

import java.io.*;
import java.util.Arrays;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        char[] words = S.toCharArray();
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);

        for (int i = 0; i < words.length; i++)
            if (alphabets[words[i] - 'a'] == -1)
                alphabets[words[i] - 'a'] = i;
        for (int alpha : alphabets)
            bw.write(alpha + " ");

        br.close();
        bw.close();
    }
}
