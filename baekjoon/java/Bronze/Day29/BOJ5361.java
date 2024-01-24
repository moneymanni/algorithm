package Day29;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5361 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] testCase = new int[N][5];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < testCase.length; i++) {
            int A = testCase[i][0];
            int B = testCase[i][1];
            int C = testCase[i][2];
            int D = testCase[i][3];
            int E = testCase[i][4];

            double total = (BattleDroid.BLASTER_RIFLE.getPrice() * A) +
                    (BattleDroid.VISUAL_SENSOR.getPrice() * B) +
                    (BattleDroid.HEARING_SENSOR.getPrice() * C) +
                    (BattleDroid.ARM.getPrice() * D) +
                    (BattleDroid.LEGS.getPrice() * E);
            bw.write(String.format("$%.2f\n", total));
        }

        br.close();
        bw.close();
    }

    public enum BattleDroid {
        BLASTER_RIFLE(350.34),
        VISUAL_SENSOR(230.90),
        HEARING_SENSOR(190.55),
        ARM(125.30),
        LEGS(180.90);

        private final double price;
        BattleDroid (double price) {
            this.price = price;
        }
        public double getPrice () {
            return price;
        }
    }
}
