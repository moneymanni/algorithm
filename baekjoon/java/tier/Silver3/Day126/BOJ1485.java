package Silver3.Day126;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            List<Point> pointList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pointList.add(new Point(x, y));
            }

            double[] len = new double[6];

            if (isSquare(pointList))
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isSquare(List<Point> pointList) {
        double[] len = new double[6];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++)
                len[idx++] = calculateDistance(pointList.get(i), pointList.get(j));
        }

        Arrays.sort(len);

        return len[0] == len[1] && len[1] == len[2] && len[2] == len[3] && len[4] == len[5];
    }

    private static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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