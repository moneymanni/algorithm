package Day29;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            int N = testCase[i][0];  // 모든 닭의 다리수의 합
            int M = testCase[i][1];  // 닭의 수

            int u = 2 * M - N;  // 다리가 잘린 닭의 수
            int t = N - M;  // 멀쩡한 닭의 수
            bw.write(String.format("%d %d\n", u, t));
        }

        br.close();
        bw.close();
    }
}
