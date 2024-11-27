package Silver5.Day86;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15312 {
    public static final int[] UPPER_ALPHABET_STROKES = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++)
            sb.append(A.charAt(i)).append(B.charAt(i));

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < sb.length(); i++)
            queue.offer(UPPER_ALPHABET_STROKES[sb.charAt(i) - 'A']);

        while (queue.size() > 2) {
            int prev = queue.poll();
            for (int i = 0; i < queue.size(); i++) {
                int num = queue.poll();
                queue.offer((num + prev) % 10);
                prev = num;
            }
        }

        bw.write(String.format("%d%d", queue.poll(), queue.poll()));

        br.close();
        bw.flush();
        bw.close();
    }
}
