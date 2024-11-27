package Silver3.Day119;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(B);

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int start = 0, end = M - 1;
                int idx = 0;
                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (B[mid] < A[i]) {
                        start = mid + 1;
                        idx = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                cnt += idx;
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
