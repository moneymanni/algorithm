package StepByStep.setandmap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cardMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            if (cardMap.containsKey(num)) {
                bw.write(cardMap.get(num) + " ");
            } else {
                bw.write("0 ");
            }
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
