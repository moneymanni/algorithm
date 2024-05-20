package Silver3.Day122;

import java.io.*;

public class BOJ9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        String winner = N % 2 == 1 ? "SK" : "CY";
        bw.write(winner);

        br.close();
        bw.flush();
        bw.close();
    }
}
