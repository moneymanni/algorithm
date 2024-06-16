package Silver2.Day143;

import java.io.*;

public class BOJ17427 {
    private static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        g(N);

        long sum = 0;

        for (int i = 1; i <= N; i++)
            sum += nums[i];

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void g(int N) {
        nums = new long[N + 1];

        for (int i = 1; i <= N; i++) {

            for (int j = i; j <= N; j += i)
                nums[j] += i;
        }
    }
}
