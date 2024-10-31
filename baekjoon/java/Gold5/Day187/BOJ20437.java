package Gold5.Day187;

import java.io.*;

public class BOJ20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            bw.write(playStrGame(W, K) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String playStrGame(String str, int k) {
        if (k == 1)
            return "1 1";

        int[] alphabets = new int[26];

        for (int i = 0; i < str.length(); i++)
            alphabets[str.charAt(i) - 'a']++;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length(); i++) {
            if (alphabets[str.charAt(i) - 'a'] < k)
                continue;

            int cnt = 1;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    cnt++;

                if (cnt == k) {
                    min = Math.min(min, j - i + 1);
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
            return "-1";

        return String.format("%d %d", min, max);
    }
}
