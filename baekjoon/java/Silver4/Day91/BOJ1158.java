package Silver4.Day91;

import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.offer(i);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++)
                queue.offer(queue.poll());

            list.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1)
                sb.append(", ");
        }
        sb.append(">");
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
