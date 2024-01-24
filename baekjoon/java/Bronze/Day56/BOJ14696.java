package Day56;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14696 {
    public static final int CARD_NUM = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] A = new int[CARD_NUM + 1];
            int[] B = new int[CARD_NUM + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ANum = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens())
                A[Integer.parseInt(st.nextToken())]++;
            st = new StringTokenizer(br.readLine());
            int BNum = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens())
                B[Integer.parseInt(st.nextToken())]++;

            boolean isDraw = false;
            for (int j = CARD_NUM; j > 0; j--) {
                if (A[j] > B[j]) {
                    bw.write("A");
                    isDraw = false;
                    break;
                } else if (A[j] < B[j]) {
                    bw.write("B");
                    isDraw = false;
                    break;
                } else {
                    isDraw = true;
                }
            }

            if (isDraw)
                bw.write("D");
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
