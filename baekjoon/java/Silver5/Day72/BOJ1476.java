package Silver5.Day72;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());  // 지구을 나타내는 수
        int S = Integer.parseInt(st.nextToken());  // 태양을 나타내는 수
        int M = Integer.parseInt(st.nextToken());  // 달을 나타내는 수

        int earth = 1, sun = 1, moon = 1;
        int result = 1;
        while (true) {
            if (earth == E && sun == S && moon == M)
                break;

            earth = earth < 15 ? earth + 1 : 1;
            sun = sun < 28 ? sun + 1 : 1;
            moon = moon < 19 ? moon + 1 : 1;

            result++;
        }
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
