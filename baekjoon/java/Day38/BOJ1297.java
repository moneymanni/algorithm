package Day38;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double D = Double.parseDouble(st.nextToken());  // 대각선 길이
        double H = Double.parseDouble(st.nextToken());  // 높이 비율
        double W = Double.parseDouble(st.nextToken());  // 너비 비율

        double sqrt = Math.sqrt(D*D / (H*H + W*W));
        double height = sqrt * H;
        double width = sqrt * W;
        bw.write(String.format("%d %d", (int) height, (int) width));

        br.close();
        bw.close();
    }
}
