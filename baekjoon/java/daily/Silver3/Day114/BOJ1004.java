package Silver3.Day114;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            int cnt = 0;
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean startInside = isInsideCircle(x1, y1, cx, cy, r);
                boolean endInside = isInsideCircle(x2, y2, cx, cy, r);

                if ((startInside && !endInside) || (!startInside && endInside))
                    cnt++;
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isInsideCircle(int x, int y, int cx, int cy, int r) {
        return Math.pow(x - cx, 2) + Math.pow(y - cy, 2) < Math.pow(r, 2);
    }
}
