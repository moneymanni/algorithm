package Day53;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] testCase = new String[T];
        for (int i = 0; i < T; i++)
            testCase[i] = br.readLine();

        for (int i = 0; i < T; i++) {
            StringBuilder lineSB = new StringBuilder();
            StringTokenizer st = new StringTokenizer(testCase[i]);

            while (st.hasMoreTokens()) {
                StringBuilder wordSB = new StringBuilder();
                wordSB.append(st.nextToken());
                lineSB.append(wordSB.reverse()).append(" ");
            }

            bw.write(lineSB.toString() + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
