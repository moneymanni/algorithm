package Day37;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        long minSum = Long.parseLong(A.replace('6', '5'))
                + Long.parseLong(B.replace('6', '5'));
        long maxSum = Long.parseLong(A.replace('5', '6'))
                + Long.parseLong(B.replace('5', '6'));

        bw.write(String.format("%d %d", minSum, maxSum));

//        char[] minA = A.toCharArray();
//        char[] maxA = A.toCharArray();
//        for (int i = 0; i < A.length(); i++) {
//            if (minA[i] == '5')
//                maxA[i] = '6';
//            else if (minA[i] == '6')
//                minA[i] = '5';
//        }
//
//        char[] minB = B.toCharArray();
//        char[] maxB = B.toCharArray();
//        for (int i = 0; i < B.length(); i++) {
//            if (minB[i] == '5')
//                maxB[i] = '6';
//            else if (minB[i] == '6')
//                minB[i] = '5';
//        }
//
//        long minSum = Long.parseLong(String.valueOf(minA))
//                + Long.parseLong(String.valueOf(minB));
//        long maxSum = Long.parseLong(String.valueOf(maxA))
//                + Long.parseLong(String.valueOf(maxB));
//
//        bw.write(String.format("%d %d", minSum, maxSum));

        br.close();
        bw.close();
    }
}
