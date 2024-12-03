package doit.day201;

import java.io.*;
import java.util.Arrays;

public class BOJ1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr);

        int maxGap = 0;

        for (int i = 0; i < N; i++) {
            maxGap = Math.max(maxGap, arr[i].index - i);
        }

        bw.write((maxGap + 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node obj) {
            return this.value - obj.value;
        }
    }
}
