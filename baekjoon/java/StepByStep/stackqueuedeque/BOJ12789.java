package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] != cnt) {
                if (!stack.isEmpty() && stack.peek() == cnt) {
                    stack.pop();
                    cnt++;
                    i--;
                } else {
                    stack.push(arr[i]);
                }
            } else {
                cnt++;
            }
        }

        boolean isNice = true;

        while (!stack.isEmpty()) {
            int value = stack.pop();

            if (value == cnt) {
                cnt++;
            } else {
                isNice = false;
                break;
            }
        }

        bw.write(isNice ? "Nice" : "Sad");

        br.close();
        bw.flush();
        bw.close();
    }
}
