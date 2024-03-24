package Silver4.Day96;

import java.io.*;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int goodWordsCnt = 0;
        while (N-- > 0) {
            String word = br.readLine();

            if (isGoodWord(word))
                goodWordsCnt++;
        }
        bw.write(goodWordsCnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isGoodWord (String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }

        return stack.isEmpty();
    }
}
