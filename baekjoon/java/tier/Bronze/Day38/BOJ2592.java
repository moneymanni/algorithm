package Day38;

import java.io.*;

public class BOJ2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    cnt[i]++;
            }
        }

        int maxCntNum = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[maxCntNum] < cnt[i])
                maxCntNum = i;
        }

        int mean = sum / nums.length;
        int mode = nums[maxCntNum];

        bw.write(String.format("%d\n%d", mean, mode));

        br.close();
        bw.close();
    }
}
