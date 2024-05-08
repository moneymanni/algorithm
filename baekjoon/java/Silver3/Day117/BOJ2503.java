package Silver3.Day117;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2503 {
    private static int N;
    private static ArrayList<Info> game = new ArrayList<>();
    private static ArrayList<String> answer = new ArrayList<>();
    private static boolean[] numUsing;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        numUsing = new boolean[10];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            game.add(new Info(num, s, b));
        }

        search("", 0);
        bw.write(answer.size() + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Info {
        int strike, ball;
        String num;
        public Info (String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    private static void search (String num, int size) {
        if (size == 3) {
            numCheck(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!numUsing[i]) {
                numUsing[i] = true;
                search(num + i, size + 1);
                numUsing[i] = false;
            }
        }
    }

    private static void numCheck (String num) {
        for (Info curr : game) {
            int s = 0;
            int b = 0;

            for (int i = 0; i < 3; i++) {
                if (curr.num.charAt(i) == num.charAt(i))
                    s++;
            }

            if (curr.strike != s)
                return;

            for (int i = 0; i < 3; i++) {
                int temp = (i + 1) % 3;
                if (num.charAt(i) == curr.num.charAt(temp))
                    b++;

                temp = (i + 2) % 3;
                if (num.charAt(i) == curr.num.charAt(temp))
                    b++;
            }

            if (curr.ball != b)
                return;
        }

        answer.add(num);
    }
}
