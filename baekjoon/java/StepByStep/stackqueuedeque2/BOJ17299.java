package StepByStep.stackqueuedeque2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {

    private static int N;
    private static int[] A, result;
    private static Map<Integer, Integer> map = new HashMap<>();
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && map.get(A[stack.peek()]) < map.get(A[i])) {
                result[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int num : result) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}
