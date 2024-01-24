package Day64;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            // 1
//            BigInteger binaryA = new BigInteger(A, 2);
//            BigInteger binaryB = new BigInteger(B, 2);
//
//            BigInteger result = binaryA.add(binaryB);
//
//            bw.write(result.toString(2) + "\n");

            // 2
            String result = addBinary(A, B);
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static String addBinary (String A, String B) {
        if (A.indexOf('1') == -1) A = "0";
        else A= A.substring(A.indexOf('1'));
        if (B.indexOf('1') == -1) B = "0";
        else B= B.substring(B.indexOf('1'));

        int lenA = A.length();
        int lenB = B.length();
        int maxLen = Math.max(lenA, lenB);

        StringBuilder sb = new StringBuilder();
        int bit = 0;
        for (int i = 0; i < maxLen; i++) {
            bit += lenA - i - 1 < 0 ? 0 : A.charAt(lenA - i - 1) - '0';
            bit += lenB - i - 1 < 0 ? 0 : B.charAt(lenB - i - 1) - '0';

            sb.append(bit % 2);
            bit /= 2;
        }

        if (bit == 1)
            sb.append(bit);

        return sb.reverse().toString();
    }
}
