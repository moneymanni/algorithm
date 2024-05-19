package Silver3.Day121;

import java.io.*;

public class BOJ9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String winner = N % 7 == 0 || N % 7 == 2 ? "CY" : "SK";
        bw.write(winner);

        br.close();
        bw.flush();
        bw.close();
    }
}
