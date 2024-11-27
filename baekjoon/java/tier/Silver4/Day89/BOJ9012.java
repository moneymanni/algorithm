package Silver4.Day89;

import java.io.*;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            if (isVPS(str))
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isVPS (String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ps = str.charAt(i);

            if (ps == '(') {
                stack.push(ps);
            } else if (ps == ')') {
                if (stack.empty())
                    return false;

                char prev = stack.pop();
                if (prev == ')')
                    return false;
            }
        }

        return stack.empty();
    }
}
