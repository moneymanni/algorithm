package Gold5.Day178;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Line> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Line(x, y));
        }

        Collections.sort(list);

        int min = list.get(0).x;
        int max = list.get(0).y;
        int len = max - min;

        for (Line line : list) {
            if (min <= line.x && line.y <= max)
                continue;
            else if (line.x < max)
                len += line.y - max;
            else
                len += line.y - line.x;

            min = line.x;
            max = line.y;
        }

        bw.write(len + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Line implements Comparable<Line> {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line obj) {
            if (this.x == obj.x)
                return this.y - obj.y;

            return this.x - obj.x;
        }
    }
}
