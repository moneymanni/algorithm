package Day9;

import java.io.*;

public class BOJ4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().strip());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            bw.write(i + ". " + line + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
