package doIt.day237;

import java.io.*;
import java.util.*;

public class BOJ17472 {

    private static final int[] DR = { -1, 0, 1, 0 };
    private static final int[] DC = { 0, 1, 0, -1 };

    private static int N, M, sNum;
    private static int[] parent;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<int[]> list;
    private static ArrayList<ArrayList<int[]>> sumList;
    private static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sNum = 1;
        map = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();
        sumList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(list);
                }
            }
        }

        pq = new PriorityQueue<>();

        for (int i = 0; i < sumList.size(); i++) {
            ArrayList<int[]> curr = sumList.get(i);

            for (int j = 0; j < curr.size(); j++) {
                int r = curr.get(j)[0];
                int c = curr.get(j)[1];
                int currS = map[r][c];

                for (int k = 0; k < 4; k++) {
                    int dr = DR[k];
                    int dc = DC[k];
                    int len = 0;

                    while (r + dr >= 0 && r + dr < N && c + dc >= 0 && c + dc < M) {
                        if (map[r + dr][c + dc] == currS) {
                            break;
                        } else if (map[r + dr][c + dc] != 0) {
                            if (len > 1) {
                                pq.add(new Edge(currS, map[r + dr][c + dc], len));
                            }
                            break;
                        } else {
                            len++;
                        }

                        if (dr < 0) dr--;
                        else if (dr > 0) dr++;
                        else if (dc < 0) dc--;
                        else if (dc > 0) dc++;
                    }
                }
            }
        }

        parent = new int[sNum];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (find(curr.s) != find(curr.e)) {
                union(curr.s, curr.e);
                result += curr.v;
                useEdge++;
            }
        }

        if (useEdge == sNum - 2) {
            bw.write(result + "\n");
        } else {
            bw.write("-1\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        list = new ArrayList<>();

        queue.add(new int[]{i, j});
        list.add(new int[]{i, j});

        visited[i][j] = true;
        map[i][j] = sNum;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c=  curr[1];

            for (int k = 0; k < 4; k++) {
                int dr = DR[k];
                int dc = DC[k];

                while (r + dr >= 0 && r + dr < N && c + dc >= 0 && c + dc < M) {
                    if (map[r + dr][c + dc] != 0 && !visited[r + dr][c + dc]) {
                        addNode(r + dr, c + dc, queue);
                    } else {
                        break;
                    }

                    if (dr < 0) dr--;
                    else if (dr > 0) dr++;
                    else if (dc < 0) dc--;
                    else if (dc > 0) dc++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;
        list.add(new int[]{i, j});
        queue.add(new int[]{i, j});
    }

    private static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge obj) {
            return Integer.compare(this.v, obj.v);
        }
    }
}
