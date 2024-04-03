package Silver4.Day105;

import java.io.*;
import java.util.Arrays;

public class BOJ13015 {
    static char[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        paper = new char[N*2-1][N*2+(N-2)*2+1];
        for (char[] chars : paper) Arrays.fill(chars, ' ');

        stampStar(N);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < paper.length; i++) {
            int starCnt = 0;
            for (int j = 0; j < paper[i].length; j++) {
                result.append(paper[i][j]);

                if (paper[i][j] == '*')
                    starCnt++;

                if ((i == N - 1 && starCnt == 3) || ((i != 0 && i != paper.length - 1) && starCnt == 4))
                    break;
            }
            result.append('\n');
        }
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void stampStar(int N) {
        int width = N*2+(N-2)*2+1;
        int height = N*2-1;

        for (int i = 0; i < N; i++) {
            paper[0][i]
                    = paper[0][width-1-i]
                    = paper[height-1][i]
                    = paper[height-1][width-1-i]
                    = '*';
        }

        for (int i = 1; i < N; i++) {
            paper[i][i]
                    = paper[i][i+N-1]
                    = paper[i][width-N-i]
                    = paper[i][width-1-i]
                    = '*';
        }

        for (int i = 1; i < N-1; i++) {
            paper[N-1+i][N-1-i]
                    = paper[N-1+i][width-2*N+1-i]
                    = paper[N-1+i][N*2-2+i]
                    = paper[N-1+i][width-N+i]
                    = '*';
        }
    }
}
