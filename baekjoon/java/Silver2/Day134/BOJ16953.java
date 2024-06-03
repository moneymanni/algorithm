package Silver2.Day134;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = BFS(A, B);

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int BFS(long a, long b) {
        Queue<Long> queue = new LinkedList<>();
        int cnt = 0;

        queue.add(a);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long num = queue.poll();

                if (num == b)
                    return ++cnt;

                if (num * 2 <= b)
                    queue.add(num * 2);
                if (num * 10 + 1 <= b)
                    queue.add(num * 10 + 1);
            }

            cnt++;
        }

        return -1;
    }
}
