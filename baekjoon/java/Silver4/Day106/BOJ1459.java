package Silver4.Day106;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long result = 0;
        if (2 * W < S)
            result = (X + Y) * W;
        else if (2 * W > 2 * S)
            result = (Math.abs(X - Y) % 2) * W + (Math.abs(X - Y) / 2) * 2 * S + Math.min(X, Y) * S;
        else
            result = Math.abs(X - Y) * W + Math.min(X, Y) * S;

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
