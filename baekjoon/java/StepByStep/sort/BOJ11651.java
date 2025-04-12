package StepByStep.sort;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11651 {

    private static Point[] points, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        points = new Point[N];
        temp = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        mergeSort(0, N - 1);

        for (Point point : points) {
            bw.write(String.format("%d %d\n", point.x, point.y));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = new Point(points[i]);
        }

        int k = start;
        int idx1 = start, idx2 = mid + 1;

        while (idx1 <= mid && idx2 <= end) {
            if (temp[idx1].y < temp[idx2].y) {
                points[k++] = new Point(temp[idx1++]);
            } else if (temp[idx1].y > temp[idx2].y) {
                points[k++] = new Point(temp[idx2++]);
            } else {
                if (temp[idx1].x < temp[idx2].x) {
                    points[k++] = new Point(temp[idx1++]);
                } else {
                    points[k++] = new Point(temp[idx2++]);
                }
            }
        }

        while (idx1 <= mid) {
            points[k++] = new Point(temp[idx1++]);
        }
        while (idx2 <= end) {
            points[k++] = new Point(temp[idx2++]);
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
    }
}
