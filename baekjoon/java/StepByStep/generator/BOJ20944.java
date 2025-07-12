package StepByStep.generator;

import java.io.*;

public class BOJ20944 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write("a".repeat(N));

        br.close();
        bw.flush();
        bw.close();
    }

}
