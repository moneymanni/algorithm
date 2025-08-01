package StepByStep.geometry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Node node1 = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Node node2 = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Node node3 = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int result = (node1.x * node2.y + node2.x * node3.y + node3.x * node1.y)
                - (node2.x * node1.y + node3.x * node2.y + node1.x * node3.y);

        if (result == 0) {
            bw.write("0\n");
        } else if (result > 1) {
            bw.write("1\n");
        } else {
            bw.write("-1\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
