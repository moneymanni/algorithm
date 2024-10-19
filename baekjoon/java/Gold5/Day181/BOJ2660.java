package Gold5.Day181;

import java.io.*;
import java.util.*;

public class BOJ2660 {
    private static int N;
    private static ArrayList<Candidate> candidates;
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        candidates = new ArrayList<>();
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] =new ArrayList<>();

        String input;

        while (!(input = br.readLine()).equals("-1 -1")) {
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        Collections.sort(candidates);

        int minScore = candidates.get(0).score;

        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).score != minScore)
                candidates.remove(i--);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(minScore).append(' ').append(candidates.size()).append('\n');

        for (Candidate candidate : candidates) {
            sb.append(candidate.index).append(' ');
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void BFS(int v) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(v, 0));
        visited[v] = true;

        int maxCnt = -1;

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            maxCnt = Math.max(maxCnt, currNode.count);

            for (int nextNode : list[currNode.index]) {
                if (!visited[nextNode]) {
                    queue.offer(new Node(nextNode, currNode.count + 1));
                    visited[nextNode] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                return;
        }

        candidates.add(new Candidate(v, maxCnt));
    }

    static class Candidate implements Comparable<Candidate> {
        int index;
        int score;

        public Candidate(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Candidate obj) {
            return score - obj.score;
        }
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
