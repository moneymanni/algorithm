package StepByStep.recursion;

import java.io.*;

public class BOJ11729 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        runTowerOfHanoi(N, 1, 2, 3);

        bw.write(String.format("%d\n", (int) Math.pow(2, N) - 1));
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void runTowerOfHanoi(int num, int start, int mid, int end) {
        if (num == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }

        runTowerOfHanoi(num - 1, start, end, mid);

        sb.append(start).append(' ').append(end).append('\n');

        runTowerOfHanoi(num - 1, mid, start, end);
    }
}
