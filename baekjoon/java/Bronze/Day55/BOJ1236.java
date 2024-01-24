package Day55;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] castle = new char[N][M];
        for (int i = 0; i < N; i++)
            castle[i] = br.readLine().toCharArray();

        boolean[] row = new boolean[N];
        boolean[] column = new boolean[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        int rowCnt = 0, columnCnt = 0;
        for (boolean t : row)
            if (!t) rowCnt++;
        for (boolean t : column)
            if (!t) columnCnt++;

        int result = Math.max(rowCnt, columnCnt);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
