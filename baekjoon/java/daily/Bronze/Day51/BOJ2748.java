package Day51;

import java.io.*;

public class BOJ2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] fibonacci = new long[n + 1];
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        bw.write(fibonacci[n] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
