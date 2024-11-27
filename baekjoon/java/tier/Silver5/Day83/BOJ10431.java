package Silver5.Day83;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        int[][] testCase = new int[P][21];
        for (int i = 0; i < testCase.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            int T = testCase[i][0];
            int steps = countSteps(testCase[i]);

            bw.write(String.format("%d %d\n", T, steps));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int countSteps (int[] arr) {
        int steps = 0;

        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (arr[j] > arr[i])
                    steps++;
            }
        }

        return steps;
    }
}
