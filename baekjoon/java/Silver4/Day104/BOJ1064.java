package Silver4.Day104;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int xA = Integer.parseInt(st.nextToken());
        int yA = Integer.parseInt(st.nextToken());
        int xB = Integer.parseInt(st.nextToken());
        int yB = Integer.parseInt(st.nextToken());
        int xC = Integer.parseInt(st.nextToken());
        int yC = Integer.parseInt(st.nextToken());

        if ((xB - xA) * (yC - yA) == (xC - xA) * (yB - yA)) {
            bw.write("-1");
        } else {
            double ab = distance(xA, yA, xB, yB);
            double ac = distance(xA, yA, xC, yC);
            double bc = distance(xB, yB, xC, yC);

            double max = Math.max(ab, Math.max(ac, bc));
            double min = Math.min(ab, Math.min(ac, bc));

            bw.write(String.valueOf(2 * (max - min)));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
