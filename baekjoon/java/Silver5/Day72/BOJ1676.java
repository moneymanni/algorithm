package Silver5.Day72;

import java.io.*;

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 5; i <= N; i *= 5)
            cnt += N / i;
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
