package Day34;

import java.io.*;

public class BOJ1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String hex = br.readLine();
        int num = Integer.parseInt(hex, 16);
        bw.write(num + "");

        br.close();
        bw.close();
    }
}
