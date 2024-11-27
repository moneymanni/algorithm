package Gold5.Day179;

import java.io.*;
import java.math.BigInteger;

public class BOJ1914 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        sb.append(new BigInteger("2").pow(N).subtract(BigInteger.ONE)).append('\n');

        if (N <= 20)
            hanoi(N, 1, 2, 3);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void hanoi(int num, int from, int via, int to) {
        if (num == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        hanoi(num - 1, from, to, via);

        sb.append(from).append(' ').append(to).append('\n');

        hanoi(num - 1, via, from, to);
    }
}
