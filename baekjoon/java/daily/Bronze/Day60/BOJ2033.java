package Day60;

import java.io.*;

public class BOJ2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        boolean raiseNum = false;
        StringBuilder sb = new StringBuilder();
        for (int i = N.length() - 1; i >= 1; i--) {
            int num = N.charAt(i) - '0';
            if (raiseNum) {
                num++;
                raiseNum = false;
            }

            raiseNum = num >= 5;
            sb.append(0);
        }

        int temp = raiseNum ? 1 : 0;
        sb.insert(0, (N.charAt(0) - '0') + temp);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
