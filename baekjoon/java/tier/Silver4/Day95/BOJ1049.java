package Silver4.Day95;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minSetPrice = Integer.MAX_VALUE;
        int minEachPrice = Integer.MAX_VALUE;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());  // 6개
            int each = Integer.parseInt(st.nextToken());

            minSetPrice = Math.min(minSetPrice, set);
            minEachPrice = Math.min(minEachPrice, each);
        }

        int minPrice;
        if (minSetPrice <= minEachPrice * 6) {
            minPrice = N / 6 * minSetPrice;
            N %= 6;
            minPrice += Math.min(N * minEachPrice, minSetPrice);
        } else {
            minPrice = N * minEachPrice;
        }

        bw.write(minPrice + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
