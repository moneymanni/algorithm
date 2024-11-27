package Silver3.Day126;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];
        for (int i = 1; i <= N; i++)
            cards[i - 1] = i;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] skills = new int[N];
        for (int i = N - 1; i >= 0; i--)
            skills[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            switch (skills[i]) {
                case 1:
                    deque.offerLast(cards[i]);
                    break;
                case 2:
                    int temp = deque.pollLast();
                    deque.offerLast(cards[i]);
                    deque.offerLast(temp);
                    break;
                case 3:
                    deque.offerFirst(cards[i]);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty())
            sb.append(deque.pollLast()).append(' ');

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
