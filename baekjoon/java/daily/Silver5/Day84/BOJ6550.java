package Silver5.Day84;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            String s = st.nextToken();
            String t = st.nextToken();

            int sIdx = 0;
            for (int i = 0; i < t.length(); i++) {
                if (sIdx == s.length())
                    break;

                char sChar = s.charAt(sIdx);
                char tChar = t.charAt(i);

                if (sChar == tChar)
                    sIdx++;
            }

            bw.write(sIdx == s.length() ? "Yes\n" : "No\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
