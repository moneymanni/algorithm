package Day9;

import java.io.*;

public class BOJ9316 {
    public static final String HELLO_JUDGE = "Hello World, Judge";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().strip());

        for (int i = 1; i <= N; i++)
            bw.write(HELLO_JUDGE + " " + i + "!\n");

        bw.flush();
        bw.close();
    }
}
