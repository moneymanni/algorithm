package Day52;

import java.io.*;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            int reverseNum = Integer.parseInt(sb.reverse().toString());
            if (num == reverseNum)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
