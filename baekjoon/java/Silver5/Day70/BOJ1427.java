package Silver5.Day70;

import java.io.*;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] nums = N.chars().map(c -> c - '0').toArray();

        // 삽입 정렬
        for (int i = 1; i < nums.length; i++) {
            int insertPoint = i;
            int insertValue = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0)
                    insertPoint = 0;
            }
            for (int j = i; j > insertPoint; j--)
                nums[j] = nums[j - 1];
            nums[insertPoint] = insertValue;
        }

        for (int i : nums)
            bw.write(i + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
