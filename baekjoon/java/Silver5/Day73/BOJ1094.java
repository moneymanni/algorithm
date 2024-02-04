package Silver5.Day73;

import java.io.*;

public class BOJ1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (X > 0) {
            cnt += X & 1;  // X의 현재 비트가 1이면 cnt를 증가시킴
            X >>= 1;  // X를 오른쪽으로 1비트 시프트
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
