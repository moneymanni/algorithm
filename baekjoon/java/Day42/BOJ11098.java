package Day42;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());

            long maxPrice = 0;
            String playerRecruit = "";
            for (int j = 0; j < p; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long price = Long.parseLong(st.nextToken());
                String player = st.nextToken();

                if (price > maxPrice) {
                    maxPrice = price;
                    playerRecruit = player;
                }
            }
            bw.write(String.format("%s\n", playerRecruit));
        }

        br.close();
        bw.close();
    }
}
