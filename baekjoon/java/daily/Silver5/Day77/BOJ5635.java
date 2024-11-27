package Silver5.Day77;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        String[][] students = new String[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                students[i][j] = st.nextToken();
        }

        Arrays.sort(students, (a, b) -> {
            int yearComp = Integer.compare(Integer.parseInt(a[3]), Integer.parseInt(b[3]));
            if (yearComp != 0) return yearComp;
            int monthComp = Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
            if (monthComp != 0) return monthComp;
            return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
        });

        bw.write(String.format("%s\n%s", students[n-1][0], students[0][0]));

        br.close();
        bw.flush();
        bw.close();
    }
}
