package Day65;

import java.io.*;

public class BOJ2684 {
    public static final int NUM_OF_COIN_TOSSED_BY_REFEREE = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1
//        int P = Integer.parseInt(br.readLine());
//        String[] testCase = new String[P];
//        for (int i = 0; i < P; i++)
//            testCase[i] = br.readLine();
//
//        for (int i = 0; i < P; i++) {
//            // 뒤뒤뒤, 뒤뒤앞, 뒤앞뒤, 뒤앞앞, 앞뒤뒤, 앞뒤앞, 앞앞뒤, 앞앞앞
//            int[] coin = new int[3];
//            for (int j = 0; j < testCase[i].length() - 2; j++) {
//                String window = testCase[i].substring(j, j + 3);
//
//                checkCoin(window, coin);
//            }
//
//            for (int value : coin) {
//                bw.write(value + " ");
//            }
//            bw.write("\n");
//        }

        // 2 (rlatjwls3333)
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine().replace('T', '0').replace('H', '1');

            int[] coin = new int[8];
            for (int i = 0; i < NUM_OF_COIN_TOSSED_BY_REFEREE - 2; i++)
                coin[Integer.parseInt(str.substring(i, i + 3), 2)]++;

            for (int i = 0; i < coin.length; i++) {
                bw.write(Integer.toString(coin[i]));
                bw.write(" ");
            }
            bw.newLine();
        }


        br.close();
        bw.flush();
        bw.close();
    }

    public static void checkCoin (String str, int[] coin) {
        switch (str) {
            case "TTT": coin[0]++; break;
            case "TTH": coin[1]++; break;
            case "THT": coin[2]++; break;
            case "THH": coin[3]++; break;
            case "HTT": coin[4]++; break;
            case "HTH": coin[5]++; break;
            case "HHT": coin[6]++; break;
            case "HHH": coin[7]++; break;
        }
    }
}
