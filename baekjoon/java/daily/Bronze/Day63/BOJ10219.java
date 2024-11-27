package Day63;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int x = 0; x < T; x++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] grill = new char[H][W];

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++)
                    grill[i][j] = str.charAt(j);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < H; i++) {
                for (int j = W - 1; j >= 0; j--)
                    sb.append(grill[i][j]);
                sb.append("\n");
            }
            bw.write(sb.toString());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
