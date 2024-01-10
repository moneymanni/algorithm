package Day63;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        char[][] article = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++)
                article[i][j] = line.charAt(j);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < ZC; k++)
                    temp.append(article[i][j]);
            }

            for (int j = 0; j < ZR; j++)
                sb.append(temp).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
