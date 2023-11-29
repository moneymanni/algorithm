package Day35;

import java.io.*;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String colorA = br.readLine().toUpperCase();
        String colorB = br.readLine().toUpperCase();
        String colorC = br.readLine().toUpperCase();

        String temp = String.format("%d%d",
                Resistance.valueOf(colorA).getValue(),
                Resistance.valueOf(colorB).getValue());
        long result = Long.parseLong(temp) * (long) Math.pow(10, Resistance.valueOf(colorC).getValue());
        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    public enum Resistance {
        BLACK(0),
        BROWN(1),
        RED(2),
        ORANGE(3),
        YELLOW(4),
        GREEN(5),
        BLUE(6),
        VIOLET(7),
        GREY(8),
        WHITE(9);

        private final int value;
        Resistance (int value) {
            this.value = value;
        }
        public int getValue () {
            return value;
        }
    }
}
