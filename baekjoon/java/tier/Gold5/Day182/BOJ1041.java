package Gold5.Day182;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long[] nums = new long[4];
        int[] arr = new int[6];

        nums[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        nums[2] = 8 * (N - 2) + 4;
        nums[3] = 4;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if (N == 1) {
            Arrays.sort(arr);

            int sum = 0;

            for (int i = 0; i < arr.length - 1; i++)
                sum += arr[i];

            bw.write(sum + "");
        } else {
            long result = 0;
            long min = arr[0];

            for (int i = 0; i < arr.length; i++)
                min = Math.min(min, arr[i]);

            result += nums[1] * min;

            min = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (j + i == 5) continue;

                    min = Math.min(min, arr[i] + arr[j]);
                }
            }

            result += nums[2] * min;

            int sum = 0;

            for (int i = 0; i < arr.length / 2; i++)
                sum += Math.min(arr[i], arr[arr.length - 1 - i]);

            result += nums[3] * sum;

            bw.write(result + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
