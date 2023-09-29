package Day4;

import java.io.*;
import java.math.BigInteger;

public class BOJ14928 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
//            BigInteger N = new BigInteger(br.readLine().strip());
//            BigInteger birth = new BigInteger("20000303");
//
//            System.out.println(N.remainder(birth));
            String N = br.readLine();
            long remain = 0;
            for (int i = 0; i < N.length(); i++)
                remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
            bw.write(remain + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
