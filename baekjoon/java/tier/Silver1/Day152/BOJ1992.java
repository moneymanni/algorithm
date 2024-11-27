package Silver1.Day152;

import java.io.*;

public class BOJ1992 {
    private static int N;
    private static int[][] video;
    private static StringBuilder quadTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        video = new int[N][N];
        quadTree = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < N; j++)
                video[i][j] = input.charAt(j) - '0';
        }

        convertQuadTree(0, 0, N);

        bw.write(quadTree.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void convertQuadTree(int x, int y, int size) {
        if (check(x, y, size)) {
            quadTree.append(video[x][y]);
            return;
        }

        quadTree.append('(');

        int localSize = size / 2;

        convertQuadTree(x, y, localSize);
        convertQuadTree(x, y + localSize, localSize);
        convertQuadTree(x + localSize, y, localSize);
        convertQuadTree(x + localSize, y + localSize, localSize);

        quadTree.append(')');
    }

    private static boolean check(int x, int y, int size) {
        int value = video[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != value)
                    return false;
            }
        }

        return true;
    }
}
