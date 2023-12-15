package Day46;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] B = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B[i] = Long.parseLong(st.nextToken());

        long[] A = new long[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = B[i] * (i + 1) - sum;
            sum = B[i] * (i + 1);
        }

        for (long l : A)
            bw.write(l + " ");

        bw.flush();
        br.close();
        bw.close();
    }
}
