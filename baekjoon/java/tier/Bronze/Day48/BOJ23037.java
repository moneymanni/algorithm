package Day48;

import java.io.*;

public class BOJ23037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[] charsNum = String.valueOf(n).toCharArray();

        long sum = 0;
        for (int i = 0; i < charsNum.length; i++) {
            int num = Integer.parseInt(String.valueOf(charsNum[i]));
            sum += (long) Math.pow(num, 5);
        }

        bw.write(sum + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
