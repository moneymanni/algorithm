package Day46;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());  // 가지고 있는 빈 병의 수
        int f = Integer.parseInt(st.nextToken());  // 발견한 빈 병의 수
        int c = Integer.parseInt(st.nextToken());  // 교환에 필요한 빈 병의 수

        int total = e + f;
        int cnt = 0;
        while (true) {
            if (total / c == 0)
                break;

            cnt += total / c;
            total = total / c + total % c;
        }
        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
