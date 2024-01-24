package Day54;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][10];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            Arrays.sort(testCase[i]);  // 배열...
            bw.write(testCase[i][7] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
