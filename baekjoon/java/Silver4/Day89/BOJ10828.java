package Silver4.Day89;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            String command = br.readLine();

            if (command.contains("push")) {
                StringTokenizer st = new StringTokenizer(command);
                command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                stack.push(num);
                continue;
            }

            String str = "";
            switch (command) {
                case "pop":
                    if (stack.empty())
                        str = "-1";
                    else
                        str = String.valueOf(stack.pop());
                    break;
                case "size":
                    str = String.valueOf(stack.size());
                    break;
                case "empty":
                    if (stack.empty())
                        str = "1";
                    else
                        str = "0";
                    break;
                case "top":
                    if (stack.empty())
                        str = "-1";
                    else
                        str = String.valueOf(stack.peek());
                    break;
            }

            bw.write(str + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
