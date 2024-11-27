package Silver3.Day127;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++)
                pq.offer(Integer.parseInt(st.nextToken()));

            if (a != 0)
                continue;

            if (!pq.isEmpty())
                sb.append(pq.poll()).append('\n');
            else
                sb.append(-1).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
