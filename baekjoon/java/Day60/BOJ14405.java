package Day60;

import java.io.*;

public class BOJ14405 {
    public static final String[] PIKACHU = {"pi", "ka", "chu"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        boolean isPossible = true;
        int idx = 0;
        while (idx < str.length()) {
            boolean matched = false;
            for (String pikachu : PIKACHU) {
                int endIdx = idx + pikachu.length();
                if (endIdx <= str.length() && str.substring(idx, endIdx).equals(pikachu)) {
                    idx = endIdx;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                isPossible = false;
                break;
            }
        }

        if (isPossible)
            bw.write("YES");
        else
            bw.write("NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
