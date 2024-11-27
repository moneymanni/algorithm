package Silver4.Day106;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        long[] prefixSum = new long[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        long sum = 0;
        for (int i = 1; i < N; i++)
            sum += (prefixSum[N] - prefixSum[i]) * nums[i];

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
