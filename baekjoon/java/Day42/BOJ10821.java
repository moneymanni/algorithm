package Day42;

import java.io.*;

public class BOJ10821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ele = br.readLine().split(",");

        int cnt = 0;
        for (int i = 0; i < ele.length; i++)
            cnt++;
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
