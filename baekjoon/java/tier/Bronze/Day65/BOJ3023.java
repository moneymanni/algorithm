package Day65;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[] line = new String[R];
        for (int i = 0; i < R; i++)
            line[i] = br.readLine();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int idxX = 1, idxY = 1;
        StringBuilder card = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                card.append(takeDot(line[i].charAt(j), idxX++, idxY, B, A));
            }
            for (int j = C - 1; j >= 0; j--) {
                card.append(takeDot(line[i].charAt(j), idxX++, idxY, B, A));
            }
            idxX = 1;
            idxY++;
            card.append("\n");
        }
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                card.append(takeDot(line[i].charAt(j), idxX++, idxY, B, A));
            }
            for (int j = C - 1; j >= 0; j--) {
                card.append(takeDot(line[i].charAt(j), idxX++, idxY, B, A));
            }
            idxX = 1;
            idxY++;
            card.append("\n");
        }

        bw.write(card.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static char takeDot (char ch, int x, int y, int errX, int errY) {
        char dot = ' ';

        if (x == errX && y == errY) {
            dot = ch == '#' ? '.' : '#';
        } else {
            dot = ch;
        }

        return dot;
    }
}
