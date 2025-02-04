package doIt.day226;

import java.io.*;
import java.util.*;

public class BOJ1516 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N + 1];
        int[] inDegree = new int[N + 1];
        int[] selfBuild = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int prev = Integer.parseInt(st.nextToken());

                if (prev == -1) break;

                list[prev].add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : list[curr]) {
                inDegree[next]--;

                result[next] = Math.max(result[next], result[curr] + selfBuild[curr]);

                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write((result[i] + selfBuild[i]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
