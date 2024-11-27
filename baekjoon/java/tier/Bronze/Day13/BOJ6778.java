package Day13;

import java.io.*;

public class BOJ6778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfAntenna = Integer.parseInt(br.readLine());
        int numOfEyes = Integer.parseInt(br.readLine());

        if (numOfAntenna >= 3 && numOfEyes <= 4)
            bw.write("TroyMartian\n");
        if (numOfAntenna <= 6 && numOfEyes >= 2)
            bw.write("VladSaturnian\n");
        if (numOfAntenna <= 2 && numOfEyes <= 3)
            bw.write("GraemeMercurian\n");

        br.close();
        bw.close();
    }
}
