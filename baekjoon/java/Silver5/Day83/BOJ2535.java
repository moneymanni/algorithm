package Silver5.Day83;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] students = new int[N][3];
        int cntCountries = 0;
        int prevCountry = 0;
        for (int i = 0; i < students.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < students[i].length; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
            if (prevCountry != students[i][0])
                cntCountries++;
        }

        Arrays.sort(students, (a, b) -> b[2] - a[2]);

        int[] countries = new int[cntCountries + 1];

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < students.length && cnt < 3; i++) {
            int country = students[i][0];
            int num = students[i][1];

            if (countries[country] < 2) {
                countries[country]++;
                cnt++;

                sb.append(country).append(' ').append(num).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
