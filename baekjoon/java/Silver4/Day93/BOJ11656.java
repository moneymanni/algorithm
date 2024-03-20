package Silver4.Day93;

import java.io.*;
import java.util.Arrays;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        String[] strs = new String[S.length()];

        for (int i = 0; i < S.length(); i++)
            strs[i] = S.substring(i);

        Arrays.sort(strs);

        for (String str : strs)
            bw.write(str + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
