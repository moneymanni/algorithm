package Day32;

import java.io.*;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();

        if (word.equals(reverse))
            bw.write("1");
        else
            bw.write("0");

        br.close();
        bw.close();
    }
}
