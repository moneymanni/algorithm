package Day35;

import java.io.*;
import java.math.BigInteger;

public class BOJ1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String oct = br.readLine();

        BigInteger num = new BigInteger(oct, 8);
        String binary = num.toString(2);
        bw.write(binary);

        br.close();
        bw.close();
    }
}
