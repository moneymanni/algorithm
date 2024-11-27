package Silver1.Day151;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074 {
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Z(r, c, (int) Math.pow(2, N));

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void Z(int x, int y, int size) {
        if (size == 1)
            return;

        if (x < size / 2 && y < size / 2) {
            Z(x, y, size / 2);
        } else if (x < size / 2 && y >= size / 2) {
            cnt += size * size / 4;
            Z(x, y - size / 2, size / 2);
        } else if (x >= size / 2 && y < size / 2) {
            cnt += (size * size / 4) * 2;
            Z(x - size / 2, y, size / 2);
        } else {
            cnt += (size * size / 4) * 3;
            Z(x - size / 2, y - size / 2, size / 2);
        }
    }
}
