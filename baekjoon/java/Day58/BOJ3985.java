package Day58;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][2];
        for (int i = 0; i < paper.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paper[i].length; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] cake = new boolean[L + 1];
        int maxNum = Integer.MIN_VALUE, maxIdx = -1;
        int expectedMaxNum = Integer.MIN_VALUE, expectedMaxIdx = -1;
        for (int i = 0; i < paper.length; i++) {
            int P = paper[i][0];
            int K = paper[i][1];
            int cnt = 0;

            if (expectedMaxNum < K - P) {
                expectedMaxNum = K - P;
                expectedMaxIdx = i + 1;
            }

            for (int j = P; j <= K; j++) {
                if (!cake[j]) {
                    cnt++;
                    cake[j] = true;
                }
            }

            if (maxNum < cnt) {
                maxIdx = i + 1;
                maxNum = cnt;
            }
        }

        bw.write(String.format("%d\n%d", expectedMaxIdx, maxIdx));

        br.close();
        bw.flush();
        bw.close();
    }
}
