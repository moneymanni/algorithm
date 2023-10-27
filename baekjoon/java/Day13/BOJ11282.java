package Day13;

import java.io.*;

public class BOJ11282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ch = Integer.parseInt(br.readLine());

        bw.write((char)(ch + 44031) + "");

        br.close();
        bw.close();
    }
}
