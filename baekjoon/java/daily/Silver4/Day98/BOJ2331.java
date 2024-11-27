package Silver4.Day98;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            int num = list.get(list.size() - 1);

            int sum = 0;
            while (num > 0) {
                sum += (int) Math.pow(num % 10, P);
                num /= 10;
            }

            if (list.contains(sum)) {
                bw.write(list.indexOf(sum) + "");
                break;
            }

            list.add(sum);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
