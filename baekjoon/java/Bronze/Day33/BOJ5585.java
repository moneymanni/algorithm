package Day33;

import java.io.*;

public class BOJ5585 {
    public static final int[] JPY_COIN = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int change = 1000 - Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < JPY_COIN.length; i++) {
            result += change / JPY_COIN[i];
            change %= JPY_COIN[i];

            if (change == 0)
                break;
        }
        bw.write(result + "");

        br.close();
        bw.close();
    }
}
