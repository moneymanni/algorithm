package StepByStep.stackqueuedeque;

import java.io.*;
import java.util.*;

public class BOJ24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (A[i] == 0) {
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            deque.addFirst(num);
            resultList.add(deque.pollLast());
        }

        for (Integer i : resultList) {
            bw.write(i + " ");
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
