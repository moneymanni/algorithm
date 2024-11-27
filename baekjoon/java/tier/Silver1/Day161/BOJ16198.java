package Silver1.Day161;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16198 {
    private static int N;
    private static int result;
    private static ArrayList<Integer> W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            W.add(Integer.parseInt(st.nextToken()));

        gatherEnergy(0, 0);

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void gatherEnergy(int depth, int sum) {
        if (depth == N - 2) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 1; i < W.size() - 1; i++) {
            sum += W.get(i - 1) * W.get(i + 1);
            int num = W.remove(i);

            gatherEnergy(depth + 1, sum);

            W.add(i, num);
            sum -= W.get(i - 1) * W.get(i + 1);
        }
    }
}
