package Silver5.Day82;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1402 {
    public static final int NUM_OF_FACTORS = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long[][] testCase = new long[T][NUM_OF_FACTORS];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM_OF_FACTORS; j++)
                testCase[i][j] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            long A = testCase[i][0];
            long B = testCase[i][1];

            bw.write("yes\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
