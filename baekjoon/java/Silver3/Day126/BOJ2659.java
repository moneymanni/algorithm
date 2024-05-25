package Silver3.Day126;

import java.io.*;
import java.util.*;

public class BOJ2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] crossCard = new int[4];
        for (int i = 0; i < 4; i++)
            crossCard[i] = Integer.parseInt(st.nextToken());

        int min = getMin(crossCard);

        int rank = findRank(min);
        bw.write(rank + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int findRank(int clockNum) {
        HashSet<Integer> clockNums = new HashSet<>();

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        int[] digits = {a, b, c, d};
                        int candiate = getMin(digits);
                        clockNums.add(candiate);
                    }
                }
            }
        }

        List<Integer> sortedClockNums = new ArrayList<>(clockNums);
        Collections.sort(sortedClockNums);

        return sortedClockNums.indexOf(clockNum) + 1;
    }

    private static int getMin(int[] crossCard) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++)
            min = Math.min(
                    min,
                    crossCard[i % 4] * 1000
                            + crossCard[(i + 1) % 4] * 100
                            + crossCard[(i + 2) % 4] * 10
                            + crossCard[(i + 3) % 4]
            );

        return min;
    }
}
