package Gold5.Day171;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    private static final String ERROR = "error";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String strNums = br.readLine();

           bw.write(solve(p, n, strNums) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String solve(String p, int n, String strNums) {
        StringTokenizer st = new StringTokenizer(strNums, "[],");

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            deque.add(Integer.parseInt(st.nextToken()));

        boolean isReversed = false;

        for (char command : p.toCharArray()) {
            if (command == 'R') {
                isReversed = !isReversed;
            } else if (command == 'D') {
                if (deque.isEmpty())
                    return ERROR;

                if (isReversed)
                    deque.pollLast();
                else
                    deque.pollFirst();
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append('[');

        if (!deque.isEmpty()) {
            if (!isReversed) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(',');
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) sb.append(',');
                }
            }
        }

        sb.append(']');

        return sb.toString();
    }
}
