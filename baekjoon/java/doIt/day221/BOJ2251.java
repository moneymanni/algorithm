package doIt.day221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2251 {

    private static final int[] sender = {0, 0, 1, 1, 2, 2};
    private static final int[] receiver = {1, 2, 0, 2, 0, 1};

    private static boolean[][] visited;
    private static boolean[] answer;
    private static int[] now;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        now = new int[3];

        now[0] = scan.nextInt();
        now[1] = scan.nextInt();
        now[2] = scan.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();

        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            for (int k = 0; k < sender.length; k++) {
                int[] next = {A, B, C};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if (next[receiver[k]] > now[receiver[k]]) {
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]];
                    next[receiver[k]] = now[receiver[k]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
