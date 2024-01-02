package Day56;

import java.io.*;

public class BOJ1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= N; i++) {
//            char[] numChars = String.valueOf(i).toCharArray();
//            boolean isGeumMinsu = true;
//            for (int j = 0; j < numChars.length; j++) {
//                if (numChars[j] != '7' && numChars[j] != '4') {
//                    isGeumMinsu = false;
//                    break;
//                }
//            }
//
//            if (isGeumMinsu)
//                max = Math.max(max, i);
//        }
//
//        bw.write(max + "");

        int max = Integer.MIN_VALUE;
        for (int i = N; i > 0; i--) {
            char[] numChars = String.valueOf(i).toCharArray();
            boolean isGeumMinsu = true;
            for (int j = 0; j < numChars.length; j++) {
                if (numChars[j] != '7' && numChars[j] != '4') {
                    isGeumMinsu = false;
                    break;
                }
            }

            if (isGeumMinsu) {
                max = i;
                break;
            }
        }

        bw.write(max + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
