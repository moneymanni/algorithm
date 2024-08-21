package Silver1.Day163;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[M];

        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, nums[i]);
        }

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < M; i++)
                sum += nums[i] % mid == 0 ? nums[i] / mid : nums[i] / mid + 1;

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
