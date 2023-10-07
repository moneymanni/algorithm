package Day11;

import java.io.*;

public class BOJ11283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int str = br.readLine().charAt(0) - 44031;
        bw.write( str + "");

        br.close();
        bw.close();
    }
}
