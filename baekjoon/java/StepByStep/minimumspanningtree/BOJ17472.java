package StepByStep.minimumspanningtree;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 {

    private static final int SEA = 0;
    private static final int LAND = 1;
    private static final int[] DX = new int[]{0, 1, 0, -1};
    private static final int[] DY = new int[]{1, 0, -1, 0};

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int islandCnt;
    private static int bridgeCnt;
    private static int totalDist;
    private static int[] parents;
    private static PriorityQueue<Bridge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 개수 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == LAND) {
                    islandCnt++;
                    BFS(new Point(i, j));
                }
            }
        }

        visited = new boolean[N][M];

        // 다리 건축
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != SEA) {
                    makeBridge(new Point(i, j));
                }
            }
        }

        // 크루스칼 알고리즘

        parents = new int[islandCnt + 1];

        for (int i = 0; i <= islandCnt; i++) {
            parents[i] = i;
        }

        while (!pq.isEmpty()) {
            Bridge bridge = pq.poll();

            if (!same(bridge.start, bridge.end)) {
                totalDist += bridge.dist;
                bridgeCnt++;
                union(bridge.start, bridge.end);
            }
        }

        bw.write((totalDist == 0 || bridgeCnt != islandCnt - 1) ? "-1\n" : totalDist + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean same(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static void makeBridge(Point point) {
        int islandIdx = map[point.x][point.y];

        for (int i = 0; i < DX.length; i++) {
            int dx = point.x;
            int dy = point.y;
            int len = 0;

            while (true) {
                dx += DX[i];
                dy += DY[i];

                if (0 <= dx && dx < N && 0 <= dy && dy < M) {
                    if (map[dx][dy] == islandIdx) {
                        break;
                    } else if (map[dx][dy] == SEA) {
                        len++;
                    } else {
                        if (len > 1) {
                            pq.add(new Bridge(islandIdx, map[dx][dy], len));
                        }
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    private static void BFS(Point point) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(point);
        map[point.x][point.y] = islandCnt;
        visited[point.x][point.y] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < DX.length; i++) {
                int dx = curr.x + DX[i];
                int dy = curr.y + DY[i];

                if (0 <= dx && dx < N && 0 <= dy && dy < M) {
                    if (!visited[dx][dy] && map[dx][dy] == LAND) {
                        queue.add(new Point(dx, dy));
                        map[dx][dy] = islandCnt;
                        visited[dx][dy] = true;
                    }
                }
            }
        }
    }

    private static class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int dist;

        public Bridge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Bridge obj) {
            return Integer.compare(this.dist, obj.dist);
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
