package Silver3.Day110;

import java.io.*;

public class BOJ2579 {
    static int[] stairs, sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];
        sequence = new int[N+1];
        for (int i = 1; i <= N; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        func(N);

        bw.write(sequence[N] + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static void func(int N) {
        if (N >= 1)
            sequence[1] = stairs[1];
        if (N >= 2)
            sequence[2] = stairs[1] + stairs[2];
        if (N >= 3)
            sequence[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++)
            sequence[i] = Math.max(sequence[i-3] + stairs[i-1], sequence[i-2]) + stairs[i];
    }
}
