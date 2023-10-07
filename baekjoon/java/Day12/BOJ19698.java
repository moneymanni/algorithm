package Day12;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 응모한 소의 수
        int W = Integer.parseInt(st.nextToken());  // 헛간의 가로
        int H = Integer.parseInt(st.nextToken());  // 헛간의 세로
        int L = Integer.parseInt(st.nextToken());  // 마리당 LxL

        int shed = (W / L) * (H / L);
        bw.write(Math.min(N, shed) + "");

        br.close();
        bw.close();
    }
}
