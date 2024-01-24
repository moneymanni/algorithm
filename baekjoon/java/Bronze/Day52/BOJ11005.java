package Day52;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        BigInteger N = new BigInteger(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//
//        String result = N.toString(B);
//        bw.write(result.toUpperCase());

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//
//        String result = Integer.toString(N, B).toUpperCase();
//        bw.write(result);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N != 0) {
            if (N % B >= 10)
                sb.append((char) (N % B + 'A' - 10));
            else
                sb.append((char) (N % B + '0'));
            N /= B;
        }

        bw.write(sb.reverse().toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
