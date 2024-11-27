package Silver4.Day104;

import java.io.*;

public class BOJ14495 {
    public static long[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (1 <= n && n <= 3) {
            bw.write("1");
        } else {
            fibonacci(n);
            bw.write(sequence[n] + "");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void fibonacci(int n) {
        sequence = new long[n+1];

        sequence[0] = 0;
        sequence[1] = sequence[2] = sequence[3] = 1;

        for (int i = 4; i <= n; i++)
            sequence[i] = sequence[i-1] + sequence[i-3];
    }
}
