package Day64;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ8974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] seq = new int[1001];
        int idx = 1, value = 1;
        boolean isSatisfied = false;
        while (true) {
            for (int i = 0; i < value; i++) {
                if (idx == seq.length) {
                    isSatisfied = true;
                    break;
                }

                seq[idx++] = value;
            }
            if (isSatisfied) break;

            value++;
        }

        int result = 0;
        for (int i = A; i <= B; i++) {
            result += seq[i];
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
