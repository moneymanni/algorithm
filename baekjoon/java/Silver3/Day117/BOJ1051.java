package Silver3.Day117;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++)
                square[i][j] = Integer.parseInt(String.valueOf(line.charAt(j-1)));
        }

        int result = 1;
        int minLen = Math.min(N, M);
        first: while (minLen >= 2) {
            for (int i = 1; i <= N - minLen + 1; i++) {
                for (int j = 1; j <= M - minLen + 1; j++) {
                    if (square[i][j] == square[i + minLen - 1][j + minLen - 1]
                            && square[i][j + minLen - 1] == square[i + minLen - 1][j]
                            && square[i][j] == square[i][j + minLen - 1]) {
                        result = minLen * minLen;
                        break first;
                    }
                }
            }
            minLen--;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
