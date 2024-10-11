package Gold5.Day179;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2251 {
    private static int[] capacities = new int[3];
    private static boolean[] visited = new boolean[201];
    private static boolean[][] check = new boolean[201][201];
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < capacities.length; i++)
            capacities[i] = Integer.parseInt(st.nextToken());

        DFS(0, 0, capacities[2]);

        Collections.sort(list);

        for (int num : list)
            bw.write(num + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int a, int b, int c) {
        if (check[a][b])
            return;

        if (a == 0 && !visited[c]) {
            list.add(c);
            visited[c] = true;
        }

        check[a][b] = true;

        if (a + b > capacities[1])
            DFS((a + b) - capacities[1], capacities[1], c);
        else
            DFS(0, a + b, c);

        if (a + b > capacities[0])
            DFS(capacities[0], (a + b) - capacities[0], c);
        else
            DFS(a + b, 0, c);

        if (a + c > capacities[0])
            DFS(capacities[0], b, (a + c) - capacities[0]);
        else
            DFS(a + c, b, 0);

        if (b + c > capacities[1])
            DFS(a, capacities[1], (b + c) - capacities[1]);
        else
            DFS(a, b + c, 0);

        DFS(a, 0, b + c);

        DFS(0, b, a + c);
    }
}
