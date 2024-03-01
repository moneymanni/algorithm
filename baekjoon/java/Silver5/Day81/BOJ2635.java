package Silver5.Day81;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Integer> list;
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= num; i++) {
            list = followRules(num, i);

            if (list.size() > max) {
                result = list;
                max = list.size();
            }
        }

        if (!result.isEmpty()) {
            bw.write(max + "\n");
            for (Integer i : result)
                bw.write(i + " ");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    public static List<Integer> followRules (int prev, int prev2) {
        List<Integer> list = new ArrayList<>();

        list.add(prev);
        list.add(prev2);
        int idx = 0;
        int num = list.get(idx++) - list.get(idx);
        while (num >= 0) {
            list.add(num);
            num = list.get(idx++) - list.get(idx);
        }

        return list;
    }
}
