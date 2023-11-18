package Day27;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 여름의 일 수
        int T = Integer.parseInt(st.nextToken());  // 스타후르츠가 자라는데 걸리는 일 수
        int C = Integer.parseInt(st.nextToken());  // 스타후르츠를 심을 수 있는 칸의 수
        int P = Integer.parseInt(st.nextToken());  // 스타후르츠 개당 가격

        int total = ((N - 1) / T) * C * P;
        bw.write(total + "");

        br.close();
        bw.close();
    }
}
