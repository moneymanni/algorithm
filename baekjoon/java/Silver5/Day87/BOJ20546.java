package Silver5.Day87;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20546 {
    public static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cash = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        prices = new int[14];
        for (int i = 0; i < prices.length; i++)
            prices[i] = Integer.parseInt(st.nextToken());

        int junhyeonAsset = simulateBNP(cash);
        int seongminAsset = simulateTIMING(cash);

        if (junhyeonAsset > seongminAsset)
            bw.write("BNP");
        else if (junhyeonAsset < seongminAsset)
            bw.write("TIMING");
        else
            bw.write("SAMESAME");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int simulateBNP(int cash) {
        int stocks = 0;

        for (int price : prices) {
            stocks += cash / price;  // 주식 매수
            cash %= price;  // 남은 현금
        }

        return cash + stocks * prices[13];  // 최종 자산
    }

    public static int simulateTIMING(int cash) {
        int stocks = 0;

        for (int i = 3; i < prices.length; i++) {
            // 3일 연속 상승과 하락 판별
            boolean up = prices[i-1] > prices[i-2] && prices[i-2] > prices[i-3];
            boolean down = prices[i-1] < prices[i-2] && prices[i-2] < prices[i-3];

            if (up) {  // 전량 매도
                cash += stocks * prices[i];
                stocks = 0;
            } else if (down) {  // 전량 매수
                stocks += cash / prices[i];
                cash %= prices[i];
            }
        }

        return cash + stocks * prices[13]; // 최종 자산
    }
}