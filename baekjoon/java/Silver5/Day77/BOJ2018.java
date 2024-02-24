package Silver5.Day77;

import java.io.*;

public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        while (endIdx < N) {
            if (sum == N) {
                sum += ++endIdx;
                cnt++;
            } else if (sum > N) {
                sum -= startIdx++;
            } else {
                sum += ++endIdx;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
