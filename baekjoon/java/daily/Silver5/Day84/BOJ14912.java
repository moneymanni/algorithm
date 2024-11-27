package Silver5.Day84;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String numStr = String.valueOf(i);

            for (int j = 0; j < numStr.length(); j++) {
                if ((numStr.charAt(j) - '0') == d)
                    cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
