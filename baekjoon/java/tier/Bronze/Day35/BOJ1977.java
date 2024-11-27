package Day35;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Integer> psn = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            double num = Math.sqrt(i);
            if (num % 1 == 0.0)
                psn.add(i);
        }

        if (psn.isEmpty()) {
            bw.write("-1");
        } else {
            int sum = psn.stream().mapToInt(Integer::intValue).sum();
            bw.write(String.format("%d\n%d", sum, psn.get(0)));
        }

        br.close();
        bw.close();
    }
}