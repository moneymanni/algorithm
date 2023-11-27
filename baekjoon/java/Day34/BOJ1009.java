package Day34;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1009 {
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

        for (int[] nums : testCase) {
            int a = nums[0];
            int b = nums[1];

            int result = 1;
            for (int j = 1; j <= b; j++)
                result = result * a % 10;

            result = result == 0 ? 10 : result;
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
