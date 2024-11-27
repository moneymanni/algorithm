package Silver3.Day122;

import java.io.*;
import java.util.*;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (A[i] == 0)
                list.offerLast(num);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            list.offerFirst(num);
            sb.append(list.pollLast()).append(' ');
        }
        bw.write(sb.toString().trim());

//        List<LinkedList<Integer>> queuestack = new ArrayList<>();
//
//        st = new StringTokenizer(br.readLine());
//        int[] A = new int[N];
//        for (int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//            queuestack.add(new LinkedList<>());
//        }
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++)
//            queuestack.get(i).offer(Integer.parseInt(st.nextToken()));
//
//        int M = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        st = new StringTokenizer(br.readLine());
//        while (M-- > 0) {
//            int num = Integer.parseInt(st.nextToken());
//            for (int i = 0; i < N; i++) {
//                LinkedList<Integer> deque = queuestack.get(i);
//                int option = A[i];
//
//                if (option == 0) {
//                    deque.offerLast(num);
//                    num = deque.pollFirst();
//                }
////                else if (option == 1) {
////                    deque.offerLast(num);
////                    num = deque.pollLast();
////                }
//            }
//            sb.append(num).append(' ');
//        }
//        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
