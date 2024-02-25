package Silver5.Day78;

import java.io.*;

public class BOJ13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long temp = 0;
        long prev = 1;
        long curr = 1;
        for (int i = 2; i < N; i++) {
            temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        long result = (curr * 2) + ((curr + prev) * 2);

        if (N == 1)
            bw.write("4");
        else
            bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
