package Gold5.Day186;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2116 {
    private static int N;
    private static int max;
    private static Dice[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dice = new Dice[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int[] info = new int[6];
            for (int j = 0; j < info.length; j++)
                info[j] = Integer.parseInt(st.nextToken());

            dice[i] = new Dice(info[0], info[1], info[2], info[3], info[4], info[5]);
        }

        for (int i = 0; i < 6; i++)
            search(1, i, 0);

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void search(int depth, int bottom, int sum) {
        int pair = Dice.getPairIdx(bottom);
        int localMax = -1;

        for (int i = 0; i < 6; i++) {
            if (i == pair || i == bottom)
                continue;

            localMax = Math.max(localMax, dice[depth - 1].getFace(i));
        }

        sum += localMax;

        if (depth == N) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (dice[depth - 1].getFace(pair) == dice[depth].getFace(i)) {
                search(depth + 1, i, sum);
                break;
            }
        }
    }

    static class Dice {
        int A, B, C, D, E, F;
        int[] diceFace;
        Map<Character, Object> map;

        public Dice(int A, int B, int C, int D, int E, int F) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            this.E = E;
            this.F = F;

            diceFace = new int[6];
            diceFace[0] = A;
            diceFace[1] = B;
            diceFace[2] = C;
            diceFace[3] = D;
            diceFace[4] = E;
            diceFace[5] = F;

            mapVariable();
        }

        public void mapVariable() {
            map = new HashMap<>();

            map.put('A', this.A);
            map.put('B', this.B);
            map.put('C', this.C);
            map.put('D', this.D);
            map.put('E', this.E);
            map.put('F', this.F);
        }

        public int getFace(int idx) {
            return diceFace[idx];
        }

        public static int getPairIdx(int idx) {
            switch (idx) {
                case 0:
                    return 5;
                case 1:
                    return 3;
                case 2:
                    return 4;
                case 3:
                    return 1;
                case 4:
                    return 2;
                case 5:
                    return 0;
            }

            return -1;
        }

        public int getOppositeFacesOfDice(int num) {
            if (A == num) return (int) map.get('F');
            else if (B == num) return (int) map.get('D');
            else if (C == num) return (int) map.get('E');
            else if (D == num) return (int) map.get('B');
            else if (E == num) return (int) map.get('C');
            else if (F == num) return (int) map.get('A');

            return -1;
        }

        public int getOppositeFacesOfDice(char face) {
            switch (face) {
                case 'A':
                    return (int) map.get('F');
                case 'B':
                    return (int) map.get('D');
                case 'C':
                    return (int) map.get('E');
                case 'D':
                    return (int) map.get('B');
                case 'E':
                    return (int) map.get('C');
                case 'F':
                    return (int) map.get('A');
            }

            return -1;
        }
    }
}
