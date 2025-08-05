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
        Line L1 = new Line(L1Point1, L1Point2);

        st = new StringTokenizer(br.readLine());
        Point L2Point1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point L2Point2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Line L2 = new Line(L2Point1, L2Point2);

        if (ccw(L1.endPoint1, L1.endPoint2, L2.endPoint1) * ccw(L1.endPoint1, L1.endPoint2, L2.endPoint2) < 0
                && ccw(L2.endPoint1, L2.endPoint2, L1.endPoint1) * ccw(L2.endPoint1, L2.endPoint2, L1.endPoint2) < 0) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int ccw(Point point1, Point point2, Point point3) {
        return (point1.x * point2.y + point2.x * point3.y + point3.x * point1.y)
                - (point1.y * point2.x + point2.y * point3.x + point3.y * point1.x) < 0 ? 1 : -1;
    }

    private static class Line {

        Point endPoint1;
        Point endPoint2;

        public Line(Point endPoint1, Point endPoint2) {
            this.endPoint1 = endPoint1;
            this.endPoint2 = endPoint2;
        }
    }

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
