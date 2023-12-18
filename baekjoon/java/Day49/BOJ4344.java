package Day49;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        int[][] testCase = new int[C][];
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            for (int j = 0; j < N; j++)
                scores[j] = Integer.parseInt(st.nextToken());
            testCase[i] = scores;
        }

        for (int i = 0; i < C; i++) {
            int sum = Arrays.stream(testCase[i]).sum();
            double mean = sum / (double) testCase[i].length;

            int[] num = Arrays.stream(testCase[i])
                    .filter(n -> n > mean)
                    .toArray();

            double rate = 100.0 / testCase[i].length * num.length;
            bw.write(String.format("%.3f%%\n", rate));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
