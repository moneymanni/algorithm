package Silver1.Day158;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String S = br.readLine();

        int q = Integer.parseInt(br.readLine());

        int[][] alphabets = new int[S.length() + 1][26];

        for (int i = 1; i <= S.length(); i++) {
            int charNum = S.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                int prev = alphabets[i - 1][j];
                alphabets[i][j] = (j == charNum) ? prev + 1 : prev;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int find = st.nextToken().charAt(0) - 'a';
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken()) + 1;

            sb.append(alphabets[endIdx][find] - alphabets[startIdx][find]).append('\n');
        }

        bw.write(sb.toString().trim() );

        br.close();
        bw.flush();
        bw.close();
    }
}
