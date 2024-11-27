package Silver1.Day154;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int result = takeElevator(F, S, G, U, D);

        if (result != -1)
            bw.write(result + "");
        else
            bw.write("use the stairs");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int takeElevator(int totalFloor, int currFloor, int startLinkFloor, int upper, int lower) {
        boolean[] visited = new boolean[totalFloor + 1];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{currFloor, 0});
        visited[currFloor] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.remove();
            int floor = info[0];
            int cnt = info[1];

            if (floor == startLinkFloor)
                return cnt;

            int up = floor + upper;
            int down = floor - lower;

            if (up <= totalFloor && !visited[up]) {
                visited[up] = true;
                queue.add(new int[]{up, cnt + 1});
            }
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                queue.add(new int[]{down, cnt + 1});
            }
        }

        return -1;
    }
}
