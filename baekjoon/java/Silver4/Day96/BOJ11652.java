package Silver4.Day96;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> cards = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        long maxCardNum = Long.MIN_VALUE;
        int maxCardCnt = 0;
        for (Map.Entry<Long, Integer> entry : cards.entrySet()) {
            long cardNum = entry.getKey();
            int cnt = entry.getValue();

            if (maxCardCnt < cnt || (maxCardCnt == cnt && maxCardNum > cardNum)) {
                maxCardNum = cardNum;
                maxCardCnt = cnt;
            }
        }

        bw.write(maxCardNum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
