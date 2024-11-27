package Silver5.Day76;

import java.io.*;
import java.util.Arrays;

public class BOJ2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] questions = new int[8][2];
        for (int i = 0; i < 8; i++) {
            questions[i][0] = i + 1;
            questions[i][1] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(questions, (a, b) -> Integer.compare(b[1], a[1]));  // 내림차순
        Arrays.sort(questions, (a, b) -> b[1] - a[1]);  // 오름차순

        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += questions[i][1];
            nums[i] = questions[i][0];
        }

        Arrays.sort(nums);

        bw.write(sum + "\n");
        for (int num : nums)
            bw.write(num + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
