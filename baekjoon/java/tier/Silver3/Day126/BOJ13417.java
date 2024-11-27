package Silver3.Day126;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            Deque<Character> cards = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char ch = st.nextToken().charAt(0);

                if (cards.isEmpty()) {
                    cards.offerFirst(ch);
                } else {
                    if (cards.getFirst() >= ch)
                        cards.offerFirst(ch);
                    else
                        cards.offerLast(ch);
                }
            }

            while (!cards.isEmpty())
                sb.append(cards.poll());
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
