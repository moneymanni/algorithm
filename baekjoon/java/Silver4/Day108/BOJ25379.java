package Silver4.Day108;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ25379 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] A = new long[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        long left = 0, right = 0;
        long sum = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 1) {
                sum += cnt++;
                left += i;
                right += N - i - 1;
            }
        }

        long result = Math.min(left, right) - sum;
        bw.write(Long.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }
}
