package Day39;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] testCase = new int[M][3];
        for (int i = 0; i < testCase.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[N];
        int[] copyNums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
            copyNums[i] = i + 1;
        }

        for (int i = 0; i < testCase.length; i++) {
            int begin = testCase[i][0];
            int end = testCase[i][1];
            int mid = testCase[i][2];

            for (int j = 0; j < end - mid + 1; j++)
                copyNums[begin - 1 + j] = nums[mid- 1 + j];
            for (int j = 0; j < mid - begin; j++)
                copyNums[begin + end - mid + j] = nums[begin - 1 + j];

            for (int j = 0; j < nums.length; j++)
                nums[j] = copyNums[j];
        }

        for (int num : nums)
            bw.write(String.format("%d ", num));

        br.close();
        bw.close();
    }
}
