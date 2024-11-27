package Silver1.Day168;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14675 {
    private static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 2) {
                sb.append("yes").append('\n');
            } else {
                if (list[k].size() >= 2)
                    sb.append("yes").append('\n');
                else
                    sb.append("no").append('\n');
            }
        }

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
