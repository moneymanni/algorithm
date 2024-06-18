package Silver2.Day144;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] L = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            L[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(L);

        long start = 1;
        long end = L[N - 1];
        long result = 0;

        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < N; i++)
                cnt += L[i] / mid;

            if (cnt >= M) {
                if (result < mid)
                    result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
