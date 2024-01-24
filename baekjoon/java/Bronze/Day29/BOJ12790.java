package Day29;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][8];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            int hp = Math.max(testCase[i][0] + testCase[i][4], 1);
            int mp = Math.max(testCase[i][1] + testCase[i][5], 1);
            int atk = Math.max(testCase[i][2] + testCase[i][6], 0);
            int def = testCase[i][3] + testCase[i][7];

            int cp = 1 * hp + 5 * mp + 2 * atk + 2 * def;
            bw.write(cp + "\n");
        }

        br.close();
        bw.close();
    }
}
