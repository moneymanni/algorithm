package doIt.day224;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1043 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int result = 0;
        int[] trueP = new int[T];

        for (int i = 0; i < T; i++) {
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] party = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            party[i] = new ArrayList<>();
            int partySize = Integer.parseInt(st.nextToken());

            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean possible = true;
            int curr = party[i].get(0);

            for (int j = 0; j < trueP.length; j++) {
                if (checkSame(curr, trueP[j])) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result++;
            }
        }

        bw.write(result + "\n");

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

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }

}
