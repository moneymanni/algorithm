package StepByStep.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1654 {

    private static int K, N;
    private static long min, mid, max;
    private static long[] cable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cable = new long[K];
        min = 0L;
        max = 0L;

        for (int i = 0; i < K; i++) {
            cable[i] = Long.parseLong(br.readLine());
            max = Math.max(max, cable[i]);
        }

        max++;

        while (min < max) {
            mid = min + (max - min) / 2;

            long cnt = 0;

            for (int i = 0; i < cable.length; i++) {
                cnt += (cable[i] / mid);
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.write((min - 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
