package Day27;

import java.io.*;
import java.math.BigInteger;

public class BOJ5988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] K = new BigInteger[N];
        for (int i = 0; i < N; i++)
            K[i] = new BigInteger(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(K[i].mod(new BigInteger("2")).toString());
            switch (temp) {
                case 0:
                    bw.write("even\n");
                    break;
                case 1:
                    bw.write("odd\n");
                    break;
            }
        }

        br.close();
        bw.close();
    }
}
