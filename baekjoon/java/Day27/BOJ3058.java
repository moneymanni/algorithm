package Day27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] testCase = new int[T][7];
        for (int i = 0; i < testCase.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < testCase[i].length; j++)
                testCase[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < testCase[i].length; j++)
                if (testCase[i][j] % 2 == 0)
                    list.add(testCase[i][j]);

            Collections.sort(list);
            System.out.printf("%d %d\n", list.stream().mapToInt(Integer::intValue).sum(), list.get(0));
        }

        br.close();
    }
}
