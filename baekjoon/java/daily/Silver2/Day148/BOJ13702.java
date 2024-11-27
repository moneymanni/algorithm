package Silver2.Day148;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;

            long cnt = 0;

            for (int i = 0; i < N; i++)
                cnt += arr[i] / mid;

            if (cnt >= K)
                start = mid + 1;
            else
                end = mid - 1;
        }

        bw.write(end + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
