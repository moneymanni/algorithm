package doIt.day241;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14425 {

    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Node root = new Node();
        int cnt = 0;

        while (N-- > 0) {
            String text = br.readLine();
            Node curr = root;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                if (curr.next[ch - 'a'] == null) {
                    curr.next[ch - 'a'] = new Node();
                }

                curr = curr.next[ch - 'a'];

                if (i == text.length() - 1) {
                    curr.isLeaf = true;
                }
            }
        }

        while (M-- > 0) {
            String text = br.readLine();
            Node curr = root;

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);

                if (curr.next[ch - 'a'] == null) {
                    break;
                }

                curr = curr.next[ch - 'a'];

                if (i == text.length() - 1 && curr.isLeaf) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Node {
        Node[] next = new Node[26];
        boolean isLeaf = false;
    }
}
