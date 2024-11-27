package Silver3.Day120;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int currX = (p + t) % (2 * w);
        int currY = (q + t) % (2 * h);

        if (currX > w) currX = 2 * w - currX;
        if (currY > h) currY = 2 * h - currY;

        bw.write(String.format("%d %d", currX, currY));

//        int currX = p, currY = q;
//        int dx = 1, dy = 1;
//
//        int cnt = 0;
//        for (int i = 0; i < t; i++) {
//            currX += dx;
//            currY += dy;
//
//            if ((currX == w && currY == h)
//                    || (currX == w && currY == 0)
//                    || (currX == 0 && currY == h)
//                    || (currX == 0 && currY == 0)) {
//                dx *= -1;
//                dy *= -1;
//            } else if (currX == w || currX == 0) {
//                dx *= -1;
//            } else if (currY == h || currY == 0) {
//                dy *= -1;
//            }
//
//            if (currX == p && currY == q && (dx == 1 && dy == 1)) {
//                t = (t % cnt) + 1;
//                i = 0;
//            }
//        }
//
//        bw.write(String.format("%d %d", currX, currY));

        br.close();
        bw.flush();
        bw.close();
    }
}
