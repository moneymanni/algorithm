package Day33;

import java.io.*;
import java.util.Arrays;

public class BOJ2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(br.readLine());

        // 선택 정렬
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minIdx] > nums[j])
                    minIdx = j;
            }
            if (nums[i] > nums[minIdx]) {
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }

        // 평균
        int mean = Arrays.stream(nums).sum() / nums.length;
        bw.write(mean + "\n");

        // 중앙값
        int median = 0;
        median = nums[nums.length / 2];
        bw.write(median + "");

        br.close();
        bw.close();
    }
}
