package Silver1.Day167;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        Box box1 = new Box(x1, y1, x2, y2);

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        Box box2 = new Box(x1, y1, x2, y2);

        String result = solve(box1, box2);

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
    
    private static String solve(Box box1, Box box2) {
        if (box1.x1 > box2.x2
                || box1.x2 < box2.x1
                || box1.y1 > box2.y2
                || box1.y2 < box2.y1)
            return "NULL";
        else if ((box1.x1 == box2.x2 && box1.y1 == box2.y2)
                || (box1.x1 == box2.x2 && box1.y2 == box2.y1)
                || (box1.x2 == box2.x1 && box1.y1 == box2.y2)
                || (box1.x2 == box2.x1 && box1.y2 == box2.y1))
            return "POINT";
        else if (box1.x1 == box2.x2
                || box1.x2 == box2.x1
                || box1.y1 == box2.y2
                || box1.y2 == box2.y1)
            return "LINE";
        else
            return "FACE";
    }

    static class Box {
        int x1, y1;
        int x2, y2;

        public Box(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
