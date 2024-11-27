package Silver3.Day114;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temps = new int[N + 1];
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + temps[i];
        }

        int maxTemps = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++)
            maxTemps = Math.max(maxTemps, prefixSum[i+K] - prefixSum[i]);

        bw.write(maxTemps + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
