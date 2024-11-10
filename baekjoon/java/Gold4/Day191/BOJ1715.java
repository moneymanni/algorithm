package Gold4.Day191;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1715 {

    private static int N;
    private static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        cards = new int[N];

        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(br.readLine());

        bw.write(sortCards() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int sortCards() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            pq.add(cards[i]);

        int sum = 0;
        int deck1, deck2;

        while (pq.size() != 1) {
            deck1 = pq.poll();
            deck2 = pq.poll();

            sum += deck1 + deck2;

            pq.add(deck1 + deck2);
        }

        return sum;
    }
}
