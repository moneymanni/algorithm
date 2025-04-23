package StepByStep.recursion;

import java.io.*;

public class BOJ10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long result = fibonacci(N);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long fibonacci(long num) {
        if (num <= 0) {
            return 0;
        } else if (num <= 1) {
            return 1;
        }

        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
