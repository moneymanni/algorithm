package Silver4.Day97;

import java.io.*;

public class BOJ2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = N - 1; i > 0; i--) {
//            while (A[i] <= A[i-1]) {
//                cnt++;
//                A[i-1]--;
//            }
            if (A[i] <= A[i-1]) {
                cnt += A[i-1] - A[i] + 1;
                A[i-1] = A[i] - 1;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
