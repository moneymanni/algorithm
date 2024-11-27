package Silver1.Day156;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            start = Math.max(start, A[i]);
            end += A[i];
        }

        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    cnt++;
                    sum = 0;
                }

                sum += A[i];
            }

            if (sum != 0) cnt++;

            if (cnt <= M)
                end = mid - 1;
            else
                start = mid + 1;
        }

        sb.append(start);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
