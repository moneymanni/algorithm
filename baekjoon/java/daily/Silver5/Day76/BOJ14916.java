package Silver5.Day76;

import java.io.*;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            }

            n -= 2;
            cnt++;

            if (n < 0) {
                cnt = - 1;
                break;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
