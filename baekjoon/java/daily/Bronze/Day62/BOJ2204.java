package Day62;

import java.io.*;
import java.util.Arrays;

public class BOJ2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            String[] engWords = new String[n];
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                engWords[i] = br.readLine();
                words[i] = engWords[i].toLowerCase();
            }

            Arrays.sort(words);

            for (int i = 0; i < n; i++) {
                if (words[0].equals(engWords[i].toLowerCase()))
                    bw.write(engWords[i] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
