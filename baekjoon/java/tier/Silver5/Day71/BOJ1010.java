package Silver5.Day71;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        // 다리 짓기 적합한 곳 == 사이트
        // N개의 사이트와 M개의 사이트
        for (int i = 0; i < T; i++) {
            int N = testCase[i][0];
            int M = testCase[i][1];

            int max = Math.max(N, M);
            int min = Math.min(N, M);

            long result = combination(max, min);
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static long combination (int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= n - i;
            result /= i + 1;
        }
        return result;
    }
}
