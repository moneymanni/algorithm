package Silver5.Day85;

import java.io.*;
import java.util.Arrays;

public class BOJ14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] students = new double[N];
        for (int i = 0; i < N; i++)
            students[i] = Double.parseDouble(br.readLine());

        Arrays.sort(students);

        int cnt = 0;
        for (double student : students) {
            if (++cnt > 7)
                break;

            bw.write(String.format("%.3f\n", student));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
