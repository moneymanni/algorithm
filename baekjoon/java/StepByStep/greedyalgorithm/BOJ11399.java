package StepByStep.greedyalgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

    private static int N;
    private static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int time = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            time += P[i];
            sum += time;
        }

        System.out.println(sum);

        br.close();
        bw.flush();
        bw.close();
    }
}
