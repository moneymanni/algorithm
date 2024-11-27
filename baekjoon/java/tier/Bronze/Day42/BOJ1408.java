package Day42;

import java.io.*;

public class BOJ1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringCT = br.readLine().split(":");
        String[] stringMT = br.readLine().split(":");

        int ct = (Integer.parseInt(stringCT[2]))
                + (Integer.parseInt(stringCT[1]) * 60)
                + (Integer.parseInt(stringCT[0]) * 60 * 60);
        int mt = (Integer.parseInt(stringMT[2]))
                + (Integer.parseInt(stringMT[1]) * 60)
                + (Integer.parseInt(stringMT[0]) * 60 * 60);
        if (Integer.parseInt(stringCT[0]) > Integer.parseInt(stringMT[0])) {
            mt += 24 * 60 * 60;
        }

        int result = mt - ct;
        int hour = result / (60 * 60);
        int minute = (result % (60 * 60)) / 60;
        int second = (result % (60 * 60)) % 60;
        bw.write(String.format("%02d:%02d:%02d", hour, minute, second));

        br.close();
        bw.close();
    }
}
