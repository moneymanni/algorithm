package Day62;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] days = new int[N + 1];
        for (int i = 1; i <= N; i++)
            days[i] = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i - 1] + days[i];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            int value = prefixSum[i + K] - prefixSum[i];
            max = Math.max(max, value);
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
