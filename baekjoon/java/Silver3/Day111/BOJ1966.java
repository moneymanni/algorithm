package Silver3.Day111;

import java.io.*;
import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++)
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});

            int order = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                boolean isPrintable = true;

                for (int[] doc : queue) {
                    if (doc[1] > curr[1]) {
                        isPrintable = false;
                        break;
                    }
                }

                if (isPrintable) {
                    order++;
                    if (curr[0] == M) {
                        sb.append(order).append('\n');
                        break;
                    }
                } else {
                    queue.offer(curr);
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
