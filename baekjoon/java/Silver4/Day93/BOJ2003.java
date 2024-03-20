package Silver4.Day93;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        st = new StringTokenizer(br.readLine());
//        int[] A = new int[N];
//        for (int i = 0; i < N; i++)
//            A[i] = Integer.parseInt(st.nextToken());
//
//        int start = 0, end = 0;
//        int sum = 0, cnt = 0;
//        while (true) {
//            if (sum >= M)
//                sum -= A[start++];
//            else if (end == N)
//                break;
//            else
//                sum += A[end++];
//
//            if (sum == M)
//                cnt++;
//        }
//
//        bw.write(cnt + "");


        st = new StringTokenizer(br.readLine());
        int[] A = new int[N+1];
        int[] S = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = A[i] + S[i-1];
        }

        int start = 0, end = 0;
        int cnt = 0;
        while (end <= N) {
            int sum = S[end] - S[start];

            if (sum == M) {
                cnt++;
                end++;
            } else if (sum < M) {
                end++;
            } else {
                start++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
