package Day9;

import java.io.*;

public class BOJ6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Y = Integer.parseInt(br.readLine().strip());
        int M = Integer.parseInt(br.readLine().strip());

        bw.write(2 * M - Y + "");

        bw.flush();
        bw.close();
    }
}
