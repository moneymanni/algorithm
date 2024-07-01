package Silver1.Day150;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14888 {
    private static final int ADD = 0;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 3;
    private static int N;
    private static int max;
    private static int min;
    private static int[] operand;
    private static int[] operator = new int[4];
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        operand = new int[N];
        visited = new boolean[N];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            operand[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operator.length; i++)
            operator[i] = Integer.parseInt(st.nextToken());
        
        DFS(operand[0], 1);

        bw.write(String.format("%d\n%d", max, min));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int num, int depth) {
        if (depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                
                switch (i) {
                    case ADD:
                        DFS(num + operand[depth], depth + 1);
                        break;
                    case SUB:
                        DFS(num - operand[depth], depth + 1);
                        break;
                    case MUL:
                        DFS(num * operand[depth], depth + 1);
                        break;
                    case DIV:
                        DFS(num / operand[depth], depth + 1);
                        break;
                }
                
                operator[i]++;
            }
        }
    }
}
