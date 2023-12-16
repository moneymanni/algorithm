package Day47;

import java.io.*;

public class BOJ11816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strNum = br.readLine();

        int num = 0;
        if (strNum.startsWith("0x") && strNum.length() >= 3) {
            num = Integer.parseInt(strNum.substring(2), 16);
        } else if (strNum.startsWith("0")) {
            num = Integer.parseInt(strNum.substring(1), 8);
        } else {
            num = Integer.parseInt(strNum);
        }
        bw.write(num + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
