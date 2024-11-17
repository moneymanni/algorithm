package Gold4.Day194;

import java.io.*;

public class BOJ5639 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node rootNode = new Node(Integer.parseInt(br.readLine()));

        String input;

        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) break;

            int num = Integer.parseInt(input);

            rootNode.insert(num);
        }

        postOrder(rootNode);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append('\n');
    }

    static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void insert(int num) {
            if (num < this.value) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }
}
