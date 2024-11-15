package Gold4.Day193;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17144 {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int R, C, T;
    private static int[][] map;
    private static AirPurifier airPurifier;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1 && map[i + 1][0] == -1)
                airPurifier = new AirPurifier(new Node(i, 0), new Node(i + 1, 0));
        }

        while (T-- > 0) {
            spreadFineDust();
            activateAirPurifier(airPurifier.top.x, airPurifier.top.y, true);
            activateAirPurifier(airPurifier.bottom.x, airPurifier.bottom.y, false);
        }

        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1)
                    sum += map[i][j];
            }
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void spreadFineDust() {
        int[][] tempMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    tempMap[i][j] = -1;
                    continue;
                }

                tempMap[i][j] += map[i][j];

                int spreadVal = map[i][j] / 5;

                for (int k = 0; k < DX.length; k++) {
                    int nx = i + DX[k];
                    int ny = j + DY[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                        tempMap[nx][ny] += spreadVal;
                        tempMap[i][j] -= spreadVal;
                    }
                }
            }
        }

        map = tempMap;
    }

    private static void activateAirPurifier(int x, int y, boolean isTop) {
        int dir = 0;
        int prevVal = 0;

        while (true) {
            int nx = x + DX[dir];
            int ny = y + DY[dir];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                if (isTop) dir = (dir + 3) % 4;
                else dir = (dir + 1) % 4;

                continue;
            }

            if (map[nx][ny] == -1)
                break;

            int temp = map[nx][ny];
            map[nx][ny] = prevVal;
            prevVal = temp;

            x = nx;
            y = ny;
        }
    }

    static class AirPurifier {
        Node top;
        Node bottom;

        public AirPurifier(Node top, Node bottom) {
            this.top = top;
            this.bottom = bottom;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
