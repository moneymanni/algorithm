package StepByStep.generator;

import java.io.*;

public class BOJ25184 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int diff = N / 2;
        int leftVal = diff;
        int rightVal = N % 2 == 1 ? N - 1 : N;

        for (int i = 0; i < diff; i++) {
            bw.write(String.format("%d %d ", leftVal--, rightVal--));
        }

        bw.write((N % 2 == 1 ? N : "") + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}
