package Gold5.Day176;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Point[] p = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p[i] = new Point(x, y);
        }

        double result = shoelaceFormula(p);

        bw.write(String.format("%.1f", result));

        br.close();
        bw.flush();
        bw.close();
    }

    private static double shoelaceFormula(Point[] p) {
        int len = p.length;

        long a = 0, b = 0;

        for (int i = 0; i < len - 1; i++) {
            a += (long) p[i].x * p[i + 1].y;
            b += (long) p[i].y * p[i + 1].x;
        }
        a += (long) p[len - 1].x * p[0].y;
        b += (long) p[len - 1].y * p[0].x;

        return 0.5 * Math.abs(a - b);
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
