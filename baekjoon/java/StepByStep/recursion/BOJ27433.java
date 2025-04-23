package StepByStep.recursion;

import java.io.*;

public class BOJ27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long result = factorial(N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long factorial(long num) {
        if (num <= 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
