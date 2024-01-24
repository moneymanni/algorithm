package Day46;

import java.io.*;

public class BOJ8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; i * j <= n; j++)
                cnt++;
        }
        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
