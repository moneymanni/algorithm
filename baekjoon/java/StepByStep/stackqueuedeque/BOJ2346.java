package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.*;

public class BOJ2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.addLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        List<Integer> list = new ArrayList<>();

        while (N-- > 0) {
            int[] nums = deque.pollFirst();
            list.add(nums[0]);

            if (nums[1] > 0) {
                for (int i = 0; i < nums[1] - 1 && !deque.isEmpty(); i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(nums[1]) && !deque.isEmpty(); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        for (Integer i : list) {
            bw.write(i + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
