package Silver5.Day73;

import java.io.*;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());

        // N이 홀수일 때는 상근이가, 짝수일 때는 창영이가 이긴다.
        long result = N % 2;
        bw.write(result == 1 ? "SK" : "CY");

        br.close();
        bw.flush();
        bw.close();
    }
}
