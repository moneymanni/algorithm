package Silver2.Day136;

import java.io.*;
import java.util.Stack;

public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String line = br.readLine();

            bw.write(getPwd(line) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String getPwd(String str) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (Character ch : str. toCharArray()) {
            switch (ch) {
                case '<':
                    if (!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case '>':
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case '-':
                    if (!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                default:
                    leftStack.push(ch);
            }
        }

        while (!rightStack.isEmpty())
            leftStack.push(rightStack.pop());

        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty())
            sb.append(leftStack.pop());

        return sb.reverse().toString();
    }
}
