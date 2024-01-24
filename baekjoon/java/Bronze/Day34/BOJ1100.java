package Day34;

import java.io.*;

public class BOJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] chessBoard = new String[8];
        for (int i = 0; i < chessBoard.length; i++)
            chessBoard[i] = br.readLine();

        int cnt = 0;
        for (int i = 0; i < chessBoard.length; i++) {
            char[] line = chessBoard[i].toCharArray();
            if (i % 2 == 0) {
                for (int j = 0; j < line.length; j += 2)
                    if (line[j] == 'F')
                        cnt++;
            } else {
                for (int j = 1; j < line.length; j+= 2)
                    if (line[j] == 'F')
                        cnt++;
            }
        }
        bw.write(cnt + "");

        br.close();
        bw.close();
    }
}
