package StepByStep.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[0]);

        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for (String str : arr) {
            bw.write(str + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
