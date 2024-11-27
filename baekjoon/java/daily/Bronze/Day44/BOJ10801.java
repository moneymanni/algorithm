package Day44;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardA = new int[10];
        for (int i = 0; i < cardA.length; i++)
            cardA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cardB = new int[10];
        for (int i = 0; i < cardA.length; i++)
            cardB[i] = Integer.parseInt(st.nextToken());

        int winA = 0;
        int winB = 0;
        for (int i = 0; i < 10; i++) {
            if (cardA[i] > cardB[i])
                winA++;
            else if (cardA[i] < cardB[i])
                winB++;
        }

        if (winA > winB)
            bw.write("A");
        else if (winB > winA)
            bw.write("B");
        else
            bw.write("D");


        bw.flush();
        br.close();
        bw.close();
    }
}
