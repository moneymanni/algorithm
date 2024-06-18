package Silver2.Day144;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13565 {
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};
    
    private static int M, N;
    private static int[][] map;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            
            for (int j = 0; j < N; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if (map[0][i] == 0 && !visited[0][i]) {
                visited[0][i] = true;

                if (DFS(0, i)) {
                    flag = true;
                    break;
                }
            }
        }

        bw.write(flag ? "YES" : "NO");
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    private static boolean DFS(int x, int y) {
        if (x == M - 1)
            return true;

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];
            
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (DFS(nx, ny))
                        return true;
                }
            }
        }
        
        return false;
    }
}
