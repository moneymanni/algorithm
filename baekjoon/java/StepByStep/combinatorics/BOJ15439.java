package StepByStep.combinatorics;

import java.io.*;

public class BOJ15439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = N * (N - 1);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
