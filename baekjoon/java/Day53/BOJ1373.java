package Day53;

import java.io.*;
import java.math.BigInteger;

public class BOJ1373 {
    public static final int BINARY_GROUP_SIZE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // BigInteger 클래스와 내부 메서드를 사용
//        BigInteger num = new BigInteger(br.readLine(), 2);
//
//        String result = num.toString(8);
//        bw.write(result);


        // 2진수를 8진수로 변환
        String strBinaryNum = br.readLine();
        String result = convertBinaryToOctal(strBinaryNum);
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }

    public static String convertBinaryToOctal (String binaryString) {
        StringBuilder sb = new StringBuilder();
        int length = binaryString.length();
        int extraZeros = (BINARY_GROUP_SIZE - length % BINARY_GROUP_SIZE) % BINARY_GROUP_SIZE;

        binaryString = "0".repeat(extraZeros) + binaryString;

        for (int i = 0; i < length; i += BINARY_GROUP_SIZE) {
            int octalDigit = Integer.parseInt(binaryString.substring(i, i + BINARY_GROUP_SIZE), 2);
            sb.append(octalDigit);
        }

        return sb.toString();
    }
}
