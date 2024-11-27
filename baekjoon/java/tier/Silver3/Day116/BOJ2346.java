package Silver3.Day116;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer[]> depue = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            depue.offer(new Integer[]{Integer.parseInt(st.nextToken()), i + 1});

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            Integer[] num = depue.poll();
            sb.append(num[1]).append(' ');

            if (num[0] > 0) {
                for (int i = 0; i < num[0] - 1 && !depue.isEmpty(); i++)
                    depue.offerLast(depue.pollFirst());
            } else {
                for (int i = 0; i < Math.abs(num[0]) && !depue.isEmpty(); i++)
                    depue.offerFirst(depue.pollLast());
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
