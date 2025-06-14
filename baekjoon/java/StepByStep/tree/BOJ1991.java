package StepByStep.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1991 {

    private static int N;
    private static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parentVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            if (tree[parentVal - 'A'] == null) {
                tree[parentVal - 'A'] = new Node(parentVal);
            }
            if (leftVal != '.') {
                tree[leftVal - 'A'] = new Node(leftVal);
                tree[parentVal - 'A'].left = tree[leftVal - 'A'];
            }
            if (rightVal != '.') {
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[parentVal - 'A'].right = tree[rightVal - 'A'];
            }
        }

        List<Character> preChars = new ArrayList<>();
        List<Character> inChars = new ArrayList<>();
        List<Character> postChars = new ArrayList<>();

        Node.preorder(preChars, tree[0]);
        Node.inorder(inChars, tree[0]);
        Node.postorder(postChars, tree[0]);

        String pre = preChars.stream().map(String::valueOf).collect(Collectors.joining());
        String in = inChars.stream().map(String::valueOf).collect(Collectors.joining());
        String post = postChars.stream().map(String::valueOf).collect(Collectors.joining());

        bw.write(String.format("%s\n%s\n%s\n", pre, in, post));

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {

        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public static void preorder(List<Character> list, Node node) {
            if (node == null) return;

            list.add(node.value);
            preorder(list, node.left);
            preorder(list, node.right);
        }

        public static void inorder(List<Character> list, Node node) {
            if (node == null) return;

            inorder(list, node.left);
            list.add(node.value);
            inorder(list, node.right);
        }

        public static void postorder(List<Character> list, Node node) {
            if (node == null) return;

            postorder(list, node.left);
            postorder(list, node.right);
            list.add(node.value);
        }
    }
}
