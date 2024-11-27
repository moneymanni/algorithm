package Silver1.Day150;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1991 {
    static Node tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node('A', null, null);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(tree, root, left, right);
        }

        sb = new StringBuilder();
        preorder(tree);
        sb.append('\n');
        inorder(tree);
        sb.append('\n');
        postorder(tree);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void insertNode(Node node, char root, char left, char right) {
        if (node.value == root) {
            node.left = left == '.' ? null : new Node(left, null, null);
            node.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if (node.left != null)
                insertNode(node.left, root, left, right);
            if (node.right != null)
                insertNode(node.right, root, left, right);
        }
    }

    private static void preorder(Node node) {
        if (node == null)
            return;

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    static class Node {
        char value;
        Node right;
        Node left;

        public Node(char value, Node right, Node left) {
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }
}
