package Day43;

import java.io.*;

public class BOJ1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        int[] alphabets = new int[26];
        while ((line = br.readLine()) != null) {
            char[] chars = line.toCharArray();

            for (char ch : chars) {
                if (ch == ' ')
                    continue;
                else
                    alphabets[ch - 'a']++;
            }
        }

        int max = alphabets[0];
        for (int alphabet : alphabets)
            max = Math.max(max, alphabet);

        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == max) {
                char result = (char) (i + 'a');
                bw.write(String.format("%s", result));
            }
        }

        br.close();
        bw.close();
    }
}
