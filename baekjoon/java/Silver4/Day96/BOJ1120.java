package Silver4.Day96;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        String minText, maxText;
        if (A.length() <= B.length()) {
            minText = A;
            maxText = B;
        } else {
            minText = B;
            maxText = A;
        }

        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= maxText.length() - minText.length(); i++) {
            int cnt = 0;
            int idx = 0;
            for (int j = i; j < i + minText.length(); j++) {
                if (maxText.charAt(j) != minText.charAt(idx++))
                    cnt++;
            }

            minCnt = Math.min(minCnt, cnt);
        }

        bw.write(minCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
