package Day35;

import java.io.*;

public class BOJ2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = br.readLine().split("-");

        for (String word : words)
            bw.write(String.valueOf(word.charAt(0)));

        br.close();
        bw.close();
    }
}
