package Gold5.Day176;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Point[] p = new Point[3];

        for (int i = 0; i < p.length; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p[i] = new Point(x, y);
        }

        int result = CCW(p[0], p[1], p[2]);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int CCW(Point p1, Point p2, Point p3) {
        int a = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        int b = p1.y * p2.x + p2.y * p3.x + p3.y * p1.x;

        if (a - b > 0)
            return 1;
        else if (a - b < 0)
            return -1;

        return 0;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
