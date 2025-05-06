package StepByStep.greedyalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11047 {

    private static int N, K;
    private static int cnt;
    private static Integer[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A, Collections.reverseOrder());

        cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += K / A[i];
            K %= A[i];
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
