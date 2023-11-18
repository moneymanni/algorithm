package Day27;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            testCase[i][0] = Integer.parseInt(st.nextToken());
            testCase[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            int c = testCase[i][0];
            int v = testCase[i][1];
            bw.write(String.format("You get %d piece(s) and your dad gets %d piece(s).\n", c/v, c%v));
        }

        br.close();
        bw.close();
    }
}
