package Day11;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long result = 0;
        // 1.
        // N이 짝수면 2x1 타일로 해결할 수 있고, M이 짝수면 1x2 타일로 해결할 수 있다.
        // 만약 N과 M이 둘 다 홀수라면 N-1로 짝수를 만든 뒤 2x1 타일로 계산하고, 나머지를 1x2 타일로 계산한다.
//        if (N % 2 == 0)
//            result = (N / 2) * M;
//        else if (M % 2 == 0)
//            result = (M / 2) * N;
//        else
//            result = (((N - 1) / 2) * M) + (M / 2);
//        bw.write(result + "");

        // 2. N * M / 2 개로 채울 수 있다.
        bw.write(N*M/2 + "");

        br.close();
        bw.close();
    }
}
