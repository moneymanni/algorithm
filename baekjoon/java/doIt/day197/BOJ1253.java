package doit.day197;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] A = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            long find = A[i];
            int start = 0, end = N - 1;

            while (start < end) {
                if (A[start] + A[end] == find) {
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if (A[start] + A[end] < find) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);

        br.close();
        bw.flush();
        bw.close();
    }
}