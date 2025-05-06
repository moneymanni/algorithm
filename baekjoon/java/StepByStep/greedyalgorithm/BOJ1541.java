package StepByStep.greedyalgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1541 {

    private static String expression;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        expression = br.readLine();

        List<Integer> list = new ArrayList<>();
        String[] minusSplit = expression.split("-");

        for (String str : minusSplit) {
            if (str.contains("+")) {
                String[] plusSplit = str.split("\\+");

                int sum = Arrays.stream(plusSplit)
                        .mapToInt(Integer::parseInt)
                        .sum();

                list.add(sum);
            } else {
                list.add(Integer.parseInt(str));
            }
        }

        int result = list.get(0)
                - list.stream()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
