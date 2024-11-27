package Gold5.Day185;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] T = new int[N];
        long maxValue = Long.MIN_VALUE;

        for (int k = 0; k < N; k++) {
            T[k] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, T[k]);
        }

        Arrays.sort(T);

        long left = 0;
        long right = M * maxValue;
        long result = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (long k : T) {
                long cnt = mid / k;

                if (sum >= M) break;

                sum += cnt;
            }

            if (sum >= M) {
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
