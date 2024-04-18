package Silver3.Day112;

import java.io.*;
import java.util.Arrays;

public class BOJ1904 {
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamic(N);

        bw.write(sequence[N] + "");

        // 재귀함수
//        sequence = new int[1_000_001];
//        Arrays.fill(sequence, -1);
//
//        sequence[0] = 0;
//        sequence[1] = 1;
//        sequence[2] = 2;
//
//        bw.write(dynamic2(N) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dynamic(int N) {
        sequence = new int[N+1];

        if (N >= 1)
            sequence[1] = 1;
        if (N >= 2)
            sequence[2] = 2;
        if (N >= 3)
            sequence[3] = 3;

        for (int i = 4; i <= N; i++)
            sequence[i] = (sequence[i-1] + sequence[i-2]) % 15_746;
    }

//    static int dynamic2(int N) {
//        if (sequence[N] == -1)
//            sequence[N] = (dynamic2(N - 1) + dynamic2(N - 2)) % 15_746;
//
//        return sequence[N];
//    }
}
