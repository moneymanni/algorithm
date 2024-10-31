package Gold5.Day187;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());  // G = C² - P² (C: 현재 몸무게, P 이전 몸무게)

        List<Long> list = diet(G);

        for (long l : list)
            bw.write(l + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Long> diet(int g) {
        List<Long> list = new ArrayList<>();
        long prev = 1, curr = 2;

        while (curr < 100_000) {
            long powPrev = prev * prev;
            long powCurr = curr * curr;

            if (powCurr - powPrev == g)
                list.add(curr);

            if (powCurr - powPrev > g)
                prev++;
            else
                curr++;
        }

        if (list.isEmpty())
            list.add((long) -1);

        return list;
    }
}
