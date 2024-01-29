package Silver5.Day71;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.add(i);

        StringBuilder result = new StringBuilder("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++)
                queue.add(queue.poll());

            int num = queue.poll();
            if (i == N - 1)
                result.append(num).append(">");
            else
                result.append(num).append(", ");
        }
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
