package Silver5.Day71;

import java.io.*;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 0;
        while (true) {
            String strNum = String.valueOf(num);
            if (strNum.contains("666")) {
                cnt++;
                if (cnt == N)
                    break;
            }
            num++;
        }
        bw.write(num + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
