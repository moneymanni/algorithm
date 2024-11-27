package Silver1.Day165;

import java.io.*;

public class BOJ1342 {
    private static int cnt, len;
    private static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        len = input.length();

        for (int i = 0; i < len; i++)
            alphabet[input.charAt(i) - 'a']++;

        DFS(0, ' ');

        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, char prev) {
        if (depth == len) {
            cnt++;
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) continue;

            if (prev != (char) (i + 'a')) {
                alphabet[i]--;
                DFS(depth + 1, (char) (i + 'a'));
                alphabet[i]++;
            }
        }
    }
}
