package Silver3.Day111;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] jo = new int[3];
            int[] baek = new int[3];
            for (int i = 0; i < jo.length; i++)
                jo[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < baek.length; i++)
                baek[i] = Integer.parseInt(st.nextToken());

            sb.append(point(jo[0], jo[1], jo[2], baek[0], baek[1], baek[2])).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int point(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;
        else if (distance > Math.pow(r1 + r2, 2))
            return 0;
        else if (distance < Math.pow(r2 - r1, 2))
            return 0;
        else if (distance == Math.pow(r2 - r1, 2))
            return 1;
        else if (distance == Math.pow(r1 + r2, 2))
            return 1;
        else
            return 2;
    }
}
