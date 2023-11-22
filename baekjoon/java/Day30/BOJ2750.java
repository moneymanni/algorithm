package Day30;

import java.io.*;

public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(br.readLine());

        // 버블 정렬
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
        for (int num : nums)
            bw.write(num + "\n");

        br.close();
        bw.close();
    }
}
