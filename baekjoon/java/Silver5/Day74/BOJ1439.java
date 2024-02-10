package Silver5.Day74;

import java.io.*;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int cnt0 = 0, cnt1 = 0;
        int prev = S.charAt(0) - '0';
        for (int i = 1; i < S.length(); i++) {
            int binary = S.charAt(i) - '0';

            if (prev == binary)
                continue;

            if (prev == 0)
                cnt0++;
            else
                cnt1++;
            prev = binary;
        }
        int max = Math.max(cnt0, cnt1);
        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
