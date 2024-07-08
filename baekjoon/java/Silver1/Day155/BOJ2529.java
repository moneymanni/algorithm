package Silver1.Day155;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2529 {
    private static int k;
    private static char[] signs;
    private static int[] nums;
    private static boolean[] visited;
    private static String max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        signs = new char[k];
        nums = new int[k + 1];
        visited = new boolean[10];
        max = "";
        min = "9999999999";

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            signs[i] = st.nextToken().charAt(0);

        for (int i = 0; i <= 9; i++) {
            nums[0] = i;
            visited[i] = true;
            DFS(1, i);
            visited[i] = false;
        }

        bw.write(String.format("%s\n%s", max, min));

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(int depth, int prev) {
        if (depth == k + 1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= k; i++)
                sb.append(nums[i]);

            String str = sb.toString();

            if (str.compareTo(max) > 0)
                max = str;
            if (str.compareTo(min) < 0)
                min = str;

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!visited[i] && compare(prev, i, signs[depth - 1])) {
                visited[i] = true;

                nums[depth] = i;
                DFS(depth + 1, i);

                visited[i] = false;
            }
        }
    }

    private static boolean compare(int a, int b, char sign) {
        switch (sign) {
            case '<':
                return a < b;
            case '>':
                return a > b;
        }

        return false;
    }
}
