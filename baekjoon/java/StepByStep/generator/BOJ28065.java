package StepByStep.generator;

import java.io.*;

public class BOJ28065 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int left = 1;
        boolean flag = true;

        while (left <= N) {
            if (flag) {
                bw.write(String.format("%d ", N--));
            } else {
                bw.write(String.format("%d ", left++));
            }

            flag = !flag;
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
