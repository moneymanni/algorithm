package Day9;

import java.io.*;

public class BOJ24263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().strip());

        bw.write(N + "\n" + 1);

        bw.flush();
        bw.close();
    }
}
