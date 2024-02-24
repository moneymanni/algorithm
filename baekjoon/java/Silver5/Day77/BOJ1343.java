package Silver5.Day77;

import java.io.*;

public class BOJ1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();
        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");

        if (board.contains("X"))
            bw.write("-1");
        else
            bw.write(board);

        br.close();
        bw.flush();
        bw.close();
    }
}
