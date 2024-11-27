package Gold5.Day170;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1759 {
    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    private static int L, C;
    private static char[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        decodePassword(0, 0, 0, 0, new StringBuilder());

        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void decodePassword(int v, int depth, int vowelCnt, int consonantCnt, StringBuilder str) {
        if (depth == L) {
            if (vowelCnt >= 1 && consonantCnt >= 2)
                sb.append(str.toString()).append('\n');
            return;
        }

        for (int i = v; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                str.append(arr[i]);

                boolean isVowel = VOWELS.contains(arr[i]);
                decodePassword(i, depth + 1,
                        isVowel ? vowelCnt + 1 : vowelCnt,
                        isVowel ? consonantCnt : consonantCnt + 1, str);

                str.deleteCharAt(str.length() - 1);
                visited[i] = false;
            }
        }
    }
}
