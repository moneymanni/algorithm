package doIt.day230;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1854 {
    
    private static final int INF = 100_000_000;
    
    private static int N, M, K;
    private static int[][] W = new int[1_001][1_001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] distPQ = new PriorityQueue[N + 1];

        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };
        
        for (int i = 0; i <= N; i++) {
            distPQ[i] = new PriorityQueue<>(K, cp);
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            W[a][b] = c;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1, 0));
        distPQ[1].add(0);
        
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            
            for (int adjNode = 1; adjNode <= N; adjNode++) {
                if (W[u.node][adjNode] != 0) {
                    if (distPQ[adjNode].size() < K) {
                        distPQ[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.cost + W[u.node][adjNode]));
                    } else if (distPQ[adjNode].peek() > u.cost + W[u.node][adjNode]) {
                        distPQ[adjNode].poll();
                        distPQ[adjNode].add(u.cost + W[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.cost + W[u.node][adjNode]));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distPQ[i].size() == K) {
                bw.write(distPQ[i].peek() + "\n");
            } else {
                bw.write("-1\n");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    private static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node obj) {
            return Integer.compare(this.cost, obj.cost);
        }
    }
}
