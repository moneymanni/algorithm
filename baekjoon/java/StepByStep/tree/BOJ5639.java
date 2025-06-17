package StepByStep.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ5639 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;

        while ((input = br.readLine()) != null) {
            root.insert(Integer.parseInt(input));
        }

        ArrayList<Integer> list = new ArrayList<>();

        Node.postOrder(list, root);

        for (int num : list) {
            bw.write(num + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }

        public void insert(int num) {
            if (num < this.num) {
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

        public static void postOrder(List<Integer> list, Node node) {
            if (node == null) {
                return;
            }

            postOrder(list, node.left);
            postOrder(list, node.right);
            list.add(node.num);
        }
    }
}
