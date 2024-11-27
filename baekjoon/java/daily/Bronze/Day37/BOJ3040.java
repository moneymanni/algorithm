package Day37;

import java.io.*;
import java.util.Arrays;

public class BOJ3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int numsSum = Arrays.stream(nums).sum();
        boolean findDwarf = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = numsSum - (nums[i] + nums[j]);

                if (sum == 100) {
                    for (int num : nums) {
                        if (num != nums[i] && num != nums[j])
                            bw.write(num + "\n");
                    }
                    findDwarf = true;
                    break;
                }
            }
            if (findDwarf)
                break;
        }

        br.close();
        bw.close();
    }
}
