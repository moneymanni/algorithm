package Silver1.Day160;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stack = new Stack[7];

        for (int i = 0; i <= 6; i++)
            stack[i] = new Stack<>();

        int currStringNum = 0;
        int currFret = 0;
        int move = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            currStringNum = Integer.parseInt(st.nextToken());
            currFret = Integer.parseInt(st.nextToken());

            while (!stack[currStringNum].isEmpty() && stack[currStringNum].peek() > currFret) {
                stack[currStringNum].pop();
                move++;
            }

            if (stack[currStringNum].isEmpty() || stack[currStringNum].peek() < currFret) {
                stack[currStringNum].push(currFret);
                move++;
            }
        }

        bw.write(Integer.toString(move));

        br.close();
        bw.flush();
        bw.close();
    }
}
