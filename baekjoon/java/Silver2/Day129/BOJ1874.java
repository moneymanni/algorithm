package Silver2.Day129;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ1874 {
    private static Deque<Integer> stack = new LinkedList<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stack.addFirst(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peekFirst().equals(arr[cnt])) {
                stack.removeFirst();
                sb.append("-\n");
                cnt++;
            }
        }

        if (cnt == n)
            bw.write(sb.toString().trim());
        else
            bw.write("NO");

        br.close();
        bw.flush();
        bw.close();
    }
}
