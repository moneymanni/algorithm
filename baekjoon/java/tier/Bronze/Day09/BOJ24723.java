package Day9;

import java.io.*;

public class BOJ24723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().strip());

        bw.write((int) Math.pow(2, N) + "");

        bw.flush();
        bw.close();
    }
}
