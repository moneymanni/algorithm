package Silver2.Day134;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0, right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            long budget = 0;

            for (int i = 0; i < N; i++) {
                if (nums[i] > mid)
                    budget += mid;
                else
                    budget += nums[i];
            }

            if (budget <= M)
                left = mid + 1;
            else
                right = mid - 1;
        }

        bw.write(right + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
