package Day40;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] sections = new int[10][2];
        for (int i = 0; i < sections.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sections[i].length; j++)
                sections[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] cards = new int[20];
        for (int i = 0; i < cards.length; i++)
            cards[i] = i + 1;

        for (int i = 0; i < sections.length; i++) {
            int begin = sections[i][0] - 1;
            int end = sections[i][1] - 1;

            int condition = (begin + end) % 2 == 0 ? (begin + end) / 2 : (begin + end) / 2 + 1 ;
            for (int j = begin; j < condition; j++) {
                int temp = cards[j];
                cards[j] = cards[end];
                cards[end--] = temp;
            }
        }

        for (int card : cards)
            bw.write(String.format("%d ", card));

        br.close();
        bw.close();
    }
}
