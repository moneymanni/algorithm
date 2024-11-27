package Silver4.Day103;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
                cnt++;
            } else {
                double left = Math.sqrt(Math.pow(X - x, 2) + Math.pow(Y + H / 2.0 - y, 2));
                double right = Math.sqrt(Math.pow(X + W - x, 2) + Math.pow(Y + H / 2.0 - y, 2));

                if (left <= H / 2.0)
                    cnt++;
                else if (right <= H / 2.0)
                    cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
