package Gold5.Day183;

import java.io.*;

public class BOJ12919 {
    private static boolean isAB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        DFS(S, T);

        bw.write(isAB ? "1" : "0");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T))
                isAB = true;

            return;
        }

        if (T.endsWith("A"))
            DFS(S, T.substring(0, T.length() - 1));

        if (T.startsWith("B"))
            DFS(S, new StringBuilder(T.substring(1)).reverse().toString());
    }
}
