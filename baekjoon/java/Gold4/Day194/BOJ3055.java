package Gold4.Day194;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055 {

    private static final char EMPTY = '.';
    private static final char WATER = '*';
    private static final char STONE = 'X';
    private static final char HEDGEHOG = 'S';
    private static final char BEAVER_DEN = 'D';
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int R, C;
    private static char[][] map;
    private static Queue<Node> hQueue;  // hedgehog
    private static Queue<Node> wQueue;  // water

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        hQueue = new LinkedList<>();
        wQueue = new LinkedList<>();

        Node startNode = null;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == HEDGEHOG) {
                    hQueue.offer(new Node(i, j, 0));
                } else if (map[i][j] == WATER) {
                    wQueue.offer(new Node(i, j));
                }
            }
        }

        int result = escape();

        bw.write(result != -1 ? result + "\n" : "KAKTUS");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int escape() {
        while (!hQueue.isEmpty()) {
            int wLen = wQueue.size();

            for (int i = 0; i < wLen; i++) {
                Node wNode = wQueue.poll();

                for (int k = 0; k < DX.length; k++) {
                    int nx = wNode.x + DX[k];
                    int ny = wNode.y + DY[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] == EMPTY) {
                            map[nx][ny] = WATER;
                            wQueue.offer(new Node(nx, ny));
                        }
                    }
                }
            }

            int hLen = hQueue.size();

            for (int i = 0; i < hLen; i++) {
                Node hNode = hQueue.poll();

                for (int k = 0; k < DX.length; k++) {
                    int nx = hNode.x + DX[k];
                    int ny = hNode.y + DY[k];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] == BEAVER_DEN) {
                            return hNode.time + 1;
                        } else if (map[nx][ny] == EMPTY) {
                            map[nx][ny] = HEDGEHOG;
                            hQueue.offer(new Node(nx, ny, hNode.time + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
