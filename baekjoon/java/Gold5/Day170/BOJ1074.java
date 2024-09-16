package Gold5.Day170;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074 {
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        search(size, r, c);

        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void search(int size, int r, int c) {
        if (size == 1)
            return;

        if (r < size / 2 && c < size / 2) {
            search(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            cnt += size * size / 4;
            search(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {
            cnt += (size * size / 4) * 2;
            search(size / 2, r - size / 2, c);
        } else {
            cnt += (size * size / 4) * 3;
            search(size / 2, r - size / 2, c - size / 2);
        }
    }
}
