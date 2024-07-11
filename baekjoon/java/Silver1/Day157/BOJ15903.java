package Silver1.Day157;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            queue.add(Long.parseLong(st.nextToken()));

        while (m-- > 0) {
            long a = queue.poll();
            long b = queue.poll();

            queue.add(a + b);
            queue.add(a + b);
        }

        long sum = 0;

        while (!queue.isEmpty())
            sum += queue.remove();

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
