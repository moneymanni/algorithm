package Day10;

import java.io.*;

public class BOJ16486 {
    public static final double PIE = 3.141592;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        double cir = (d1 * 2) + (d2 * 2 * PIE);
        bw.write(cir + "");

        bw.flush();
        bw.close();
    }
}
