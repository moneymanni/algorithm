package StepByStep.advanced2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ25192 {

    private static final String ENTER = "ENTER";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        Set<String> set = new HashSet<>();

        while (N-- > 0) {
            String input = br.readLine();

            if (input.equals(ENTER)) {
                if (!set.isEmpty()) {
                    cnt += set.size();
                }

                set = new HashSet<>();
                continue;
            }

            set.add(input);
        }
        cnt += set.size();

        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
