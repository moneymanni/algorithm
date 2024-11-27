package Day42;

import java.io.*;

public class BOJ1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long K = 1;
        long time = 0;
        while (N > 0) {
            if (K > N) {
                K = 1;
            }
            N = N - K;
            K++;
            time++;

        }
        bw.write(time + "");

        br.close();
        bw.close();
    }
}
