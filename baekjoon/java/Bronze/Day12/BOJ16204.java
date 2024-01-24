package Day12;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());  // 총 카드 개수
        long M = Long.parseLong(st.nextToken());  // O가 적혀 있는 카드 개수
        long K = Long.parseLong(st.nextToken());  // 사용자가 적는 O 개수

        long result = Math.min(M, K) + Math.min(N-M, N-K);
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
