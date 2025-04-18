package StepByStep.factorsmultiplesprimes2;

import java.io.*;

public class BOJ13909 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = (int) Math.sqrt(N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
