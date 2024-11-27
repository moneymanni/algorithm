package Silver3.Day112;

import java.io.*;

public class BOJ2193 {
    static long[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dynamic(N);
        bw.write(sequence[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dynamic(int N) {
        sequence = new long[N+1];

        if (N >= 1)
            sequence[1] = 1;
        if (N >= 2)
            sequence[2] = 1;

        for (int i = 3; i <= N; i++)
            sequence[i] = sequence[i-1] + sequence[i-2];
    }
}
