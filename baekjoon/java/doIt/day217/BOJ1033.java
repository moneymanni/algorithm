package doIt.day217;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1033 {

    private static long lcm;
    private static ArrayList<Node>[] graph;
    private static boolean[] visited;
    private static long[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        
        lcm = 1;
        
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            
            lcm *= (p * q / gcd(p, q));  // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
        }

        D[0] = lcm;
        DFS(0);

        long mgcd = D[0];

        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i = 0; i < N; i++) {
            bw.write((D[i] / mgcd) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static void DFS(int nodeIdx) {
        visited[nodeIdx] = true;

        for (Node nextNode : graph[nodeIdx]) {
            int nextIdx = nextNode.target;

            if (!visited[nextIdx]) {
                D[nextIdx] = D[nodeIdx] * nextNode.q / nextNode.p;
                DFS(nextIdx);
            }
        }
    }

    static class Node {
        int target;
        int p;
        int q;

        public Node(int target, int p, int q) {
            this.target = target;
            this.p = p;
            this.q = q;
        }
    }
}
