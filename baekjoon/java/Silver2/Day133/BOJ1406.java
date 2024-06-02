package Silver2.Day133;

import java.io.*;
import java.util.*;

public class BOJ1406 {
    private static Stack<Character> leftStr = new Stack<>();
    private static Stack<Character> rightStr = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++)
            leftStr.push(str.charAt(i));

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0)
            run(br.readLine());

        while (!leftStr.isEmpty())
            rightStr.push(leftStr.pop());

        while (!rightStr.isEmpty())
            bw.write(rightStr.pop());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void run(String str) {
        char command = str.charAt(0);

        switch (command) {
            case 'L':
                if (!leftStr.isEmpty())
                    rightStr.push(leftStr.pop());
                break;
            case 'D':
                if (!rightStr.isEmpty())
                    leftStr.push(rightStr.pop());
                break;
            case 'B':
                if (!leftStr.isEmpty())
                    leftStr.pop();
                break;
            case 'P':
                char chr = str.charAt(2);
                leftStr.push(chr);
                break;
        }
    }
}
