package doIt.day195;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        long totalScore = 0;
        long maxScore = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            totalScore += score[i];
            maxScore = Math.max(maxScore, score[i]);
        }

        double result = totalScore * 100.0 / maxScore / N;

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
