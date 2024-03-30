package Silver4.Day101;

import java.io.*;

public class BOJ10994 {
    public static char[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int size = 4 * (N - 1) + 1;
        box = new char[size][size];

        drawStar(0, 0, N, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                sb.append(box[i][j]);
            sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void drawStar (int x, int y, int N, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i == x || i == x + size - 1 || j == y || j == y + size - 1) {
                    box[i][j] = '*';
                } else {
                    box[i][j] = ' ';
                }
            }
        }

        if (N > 1) {
            drawStar(x + 2, y + 2, N - 1, size - 4);
        }
    }
}
