package Day27;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 던진 성냥의 개수
        int W = Integer.parseInt(st.nextToken());  // 가로 크기
        int H = Integer.parseInt(st.nextToken());  // 세로 크기
        int[] len = new int[N];
        for (int i = 0; i < N; i++)
            len[i] = Integer.parseInt(br.readLine());

        for (int i =0 ; i < N; i++) {
            int matchLen = len[i];
            if (matchLen <= W)
                bw.write("DA\n");
            else if (matchLen <= H)
                bw.write("DA\n");
            else if (matchLen <= Math.sqrt(W*W + H*H))
                bw.write("DA\n");
            else
                bw.write("NE\n");
        }

        br.close();
        bw.close();
    }
}
