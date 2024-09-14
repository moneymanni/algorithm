package Gold5.Day169;

import java.io.*;

public class BOJ11729 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, N) - 1).append('\n');

        hanoi(N, 1, 2, 3);

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void hanoi(int num, int start, int mid, int to) {
        if (num == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return;
        }

        hanoi(num - 1, start, to, mid);

        sb.append(start).append(' ').append(to).append('\n');

        hanoi(num - 1, mid, start, to);
    }
}
