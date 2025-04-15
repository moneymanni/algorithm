package StepByStep.setandmap;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ11478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i <= S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                String sub = S.substring(i, j);

                set.add(sub);
            }
        }

        bw.write(set.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
