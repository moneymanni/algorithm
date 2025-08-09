package StepByStep.geometry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17386 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point L1Point1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point L1Point2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point L2Point1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point L2Point2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int first = ccw(L1Point1, L1Point2, L2Point1) * ccw(L1Point1, L1Point2, L2Point2);
        int second = ccw(L2Point1, L2Point2, L1Point1) * ccw(L2Point1, L2Point2, L1Point2);

        if (first <= 0 && second <= 0) {
            bw.write(1 + "\n");
        } else {
            bw.write(0 + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)
                - (p1.y * p2.x) - (p2.y * p3.x) - (p3.y * p1.x);

        if(result > 0) {
            return 1;
        }
        else if(result < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private static class Point {

        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

}
