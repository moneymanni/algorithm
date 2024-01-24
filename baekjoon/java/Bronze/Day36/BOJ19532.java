package Day36;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int y = (c * d - a * f) / (b * d - a * e);
        int x = (c * e - b * f) / (a * e - b * d);
        bw.write(String.format("%d %d", x, y));

        br.close();
        bw.close();
    }
}
