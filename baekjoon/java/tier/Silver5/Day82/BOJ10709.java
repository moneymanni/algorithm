package Silver5.Day82;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] zones = new char[H+1][W+1];
        for (int i = 1; i <= H; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= W; j++)
                zones[i][j] = chars[j-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= H; i++) {
            int cloudIdx = -1;
            int cnt = -1;
            for (int j = 1; j <= W; j++) {
                char ch = zones[i][j];

                if (ch == 'c') {
                    cloudIdx = j;
                    cnt = 0;
                }
                if (ch == '.' && cloudIdx != -1) {
                    cnt++;
                }
                sb.append(cnt).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
