package Day31;

import java.io.*;

public class BOJ5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        int[] time = new int[26];
        int temp = 3;
        int cnt = 0;
        for (int i = 0; i < time.length; i++) {
            if (cnt == 3) {
                cnt = 0;
                temp++;
            }
            time[i] = temp;
            if (i != 17 && i != 24) {
                cnt++;
            }
        }
        int sum = 0;
        char[] alphabets = line.toCharArray();
        for (char alpha : alphabets) {
            sum += time[alpha - 'A'];
        }
        bw.write(sum + "");

//        char[] alphabets = line.toCharArray();
//        int sum = 0;
//        for (char alpha : alphabets) {
//            int num = alpha - 'A';
//            switch (num) {
//                case 22: case 23: case 24: case 25:
//                    sum += 1;
//                case 19: case 20: case 21:
//                    sum += 1;
//                case 15: case 16: case 17: case 18:
//                    sum += 1;
//                case 12: case 13: case 14:
//                    sum += 1;
//                case 9: case 10: case 11:
//                    sum += 1;
//                case 6: case 7: case 8:
//                    sum += 1;
//                case 3: case 4: case 5:
//                    sum += 1;
//                case 0: case 1: case 2:
//                    sum += 1;
//                default:
//                    sum += 2;
//            }
//        }
//        bw.write(sum + "");

        br.close();
        bw.close();
    }
}
