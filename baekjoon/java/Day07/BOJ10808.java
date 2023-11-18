package Day7;

import java.io.*;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];

        String str = br.readLine().strip();

        for (int i = 0; i < str.length(); i++)
            alphabet[str.charAt(i) - 'a'] += 1;

        for (int i = 0; i < alphabet.length; i++)
            bw.write(String.valueOf(alphabet[i]) + " ");
        bw.close();
    }
}
