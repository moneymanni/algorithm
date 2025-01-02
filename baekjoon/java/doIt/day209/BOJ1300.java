package doIt.day209;

import java.io.*;

public class BOJ1300 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        bw.write(binarySearch(K) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long binarySearch(int K) {
        long start = 1, end = K;
        long result = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}
