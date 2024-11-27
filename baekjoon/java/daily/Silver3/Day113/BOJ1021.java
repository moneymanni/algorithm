package Silver3.Day113;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            queue.add(i);

        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int position = Integer.parseInt(st.nextToken());

            int idx = queue.indexOf(position);
            int left = idx, right = queue.size() - idx;

            if (left <= right) {
                for (int i = 0; i < left; i++)
                    queue.addLast(queue.removeFirst());
                cnt += left;
            } else {
                for (int i = 0; i < right; i++)
                    queue.addFirst(queue.removeLast());
                cnt += right;
            }

            queue.removeFirst();
        }

        bw.write(cnt+"");

        br.close();
        bw.flush();
        bw.close();
    }
}
