package Day36;

import java.io.*;

public class BOJ1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = N - N % 100; N <= (N - N % 100) + 99; i++) {
            if (i % F == 0) {
                result = i % 100;
                break;
            }
        }
        bw.write(String.format("%02d", result));

        br.close();
        bw.close();
    }
}
