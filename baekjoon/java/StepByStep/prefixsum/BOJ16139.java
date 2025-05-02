package StepByStep.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16139 {

    private static int q;
    private static String S;
    private static int[][] prefixSum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        S = br.readLine();
        q = Integer.parseInt(br.readLine());

        prefixSum = new int[S.length() + 1][26];

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            for (int j = 0; j < prefixSum[i].length; j++) {
                prefixSum[i + 1][j] += prefixSum[i][j];
            }
            prefixSum[i + 1][ch - 'a'] += 1;
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int result;
            if (l == 0) {
                result = prefixSum[r + 1][ch - 'a'];
            } else {
                result = prefixSum[r + 1][ch - 'a'] - prefixSum[l][ch - 'a'];
            }
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
