package StepByStep.Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (N-- > 0) {
            String input = br.readLine();

            if (isGroupWord(input)) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    private static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (curr != prev) {
                if (visited[curr - 'a']) {
                    return false;
                }
                visited[curr - 'a'] = true;
            }

            prev = curr;
        }

        return true;
    }
}
