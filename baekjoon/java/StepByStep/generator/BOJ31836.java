package StepByStep.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ31836 {

    private static int N;
    private static List<Integer> groupA = new ArrayList<>();
    private static List<Integer> groupB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if (N % 3 == 2) {
            groupA.add(1);
            groupB.add(2);
        }

        boolean flag = false;

        for (int i = N; i >= 3; i -= 3) {
            if (flag) {
                groupA.add(i);
                groupB.add(i - 1);
                groupB.add(i - 2);
            } else {
                groupB.add(i);
                groupA.add(i - 1);
                groupA.add(i - 2);
            }

            flag = !flag;
        }


        Collections.sort(groupA);
        Collections.sort(groupB);

        StringBuilder sb = new StringBuilder();

        sb.append(groupA.size()).append('\n');
        for (int idx : groupA) {
            sb.append(idx).append(' ');
        }

        sb.append('\n').append(groupB.size()).append('\n');
        for (int idx : groupB) {
            sb.append(idx).append(' ');
        }
        sb.append('\n');

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}
