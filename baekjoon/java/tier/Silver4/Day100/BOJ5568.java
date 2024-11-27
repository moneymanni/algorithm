package Silver4.Day100;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ5568 {
    public static int n, k;
    public static String[] cards;
    public static boolean[] visited;
    public static Set<String> hashSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new String[n];
        visited = new boolean[n];
        hashSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            cards[i] = br.readLine();

        combineCard(k, "");

        bw.write(String.valueOf(hashSet.size()) + '\n');

        br.close();
        bw.flush();
        bw.close();
    }

    public static void combineCard (int remain, String str) {
        if (remain == 0) {
            hashSet.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combineCard(remain - 1, str + cards[i]);
                visited[i] = false;
            }
        }
    }
}
