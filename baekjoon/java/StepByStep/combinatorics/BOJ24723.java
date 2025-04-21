package StepByStep.combinatorics;

import java.io.*;

public class BOJ24723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = (int) Math.pow(2, N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
