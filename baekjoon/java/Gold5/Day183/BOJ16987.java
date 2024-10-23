package Gold5.Day183;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16987 {
    private static int N;
    private static int maxValue;
    private static Egg[] eggArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        maxValue = 0;
        eggArr = new Egg[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            eggArr[i] = new Egg(S, W);
        }

        DFS(0, 1);

        bw.write(maxValue + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int cnt, int depth) {
        if (depth == N + 1) {
            maxValue = Math.max(maxValue, cnt);
            return;
        }

        if (eggArr[depth].durability <= 0 || cnt == N - 1) {
            DFS(cnt, depth + 1);
            return;
        }

        int saveCnt = cnt;

        for (int i = 1; i <= N; i++) {
            if (i == depth) continue;
            if (eggArr[i].durability <= 0) continue;

            hitEgg(depth, i);

            if (eggArr[depth].durability <= 0) cnt++;
            if (eggArr[i].durability <= 0) cnt++;

            DFS(cnt, depth + 1);

            recoveryEgg(depth, i);

            cnt = saveCnt;
        }
    }

    private static void hitEgg(int handEgg, int targetEgg) {
        eggArr[targetEgg].durability -= eggArr[handEgg].weight;
        eggArr[handEgg].durability -= eggArr[targetEgg].weight;
    }

    private static void recoveryEgg(int handEgg, int targetEgg) {
        eggArr[targetEgg].durability += eggArr[handEgg].weight;
        eggArr[handEgg].durability += eggArr[targetEgg].weight;
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
