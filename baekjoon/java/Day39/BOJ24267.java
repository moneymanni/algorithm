package Day39;

import java.io.*;

public class BOJ24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        // 조합을 이용: ₙCᵣ
        // O(n * (n-1) * (n-2) / 6) => O(n³)
        long cnt = N * (N-1) * (N-2) / 6;

        bw.write(String.format("%d\n%d", cnt, 3));

        br.close();
        bw.close();
    }
}
