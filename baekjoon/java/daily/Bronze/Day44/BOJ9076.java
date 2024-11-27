package Day44;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][5];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            Arrays.sort(testCase[i]);

            int sum = 0;
            for (int j = 0; j < testCase[i].length; j++) {
                sum += testCase[i][j];
            }
            sum -= testCase[i][0] + testCase[i][testCase[i].length - 1];

            if (Math.abs(testCase[i][testCase[i].length - 2] - testCase[i][1]) >= 4) {
                bw.write("KIN\n");
            } else {
                bw.write(String.format("%d\n", sum));
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
