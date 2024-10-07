package Gold5.Day178;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2668 {
    private static int N;

    private static int[] arr;
    private static boolean[] visited;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");

        for (int num : list)
            bw.write(num + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            DFS(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target)
            list.add(target);
    }
}
