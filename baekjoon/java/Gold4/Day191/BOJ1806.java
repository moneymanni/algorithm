package Gold4.Day191;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {

    private static int N, S;
    private static int[] arr, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        bw.write(partialSum() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int partialSum() {
        int minGap = Integer.MAX_VALUE;
        int startIdx = 0, endIdx = 0;

        while (startIdx <= endIdx && endIdx <= N) {
            int sum = prefixSum[endIdx] - prefixSum[startIdx];

            if (sum >= S) {
                minGap = Math.min(minGap, endIdx - startIdx);
                startIdx++;
            } else {
                endIdx++;
            }
        }

        return minGap == Integer.MAX_VALUE ? 0 : minGap;
    }
}
