package Silver3.Day115;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (j + i <= word.length()) {
                    String sub = word.substring(j, j + i);
                    set.add(sub);
                }
            }
        }

        bw.write(set.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
