package Day13;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] birth = new int[3];
        for (int i = 0; i < 3; i++)
            birth[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] inputYear = new int[3];
        for (int i = 0; i < 3; i++)
            inputYear[i] = Integer.parseInt(st.nextToken());

        int year1, year2, year3;
        if (birth[1] < inputYear[1])
            year1 = inputYear[0] - birth[0];
        else if (birth[1] == inputYear[1] && birth[2] <= inputYear[2])
            year1 = inputYear[0] - birth[0];
        else
            year1 = inputYear[0] - birth[0] - 1;
        year2 = inputYear[0] - birth[0] + 1;
        year3 = inputYear[0] - birth[0];
        bw.write(year1 + "\n" + year2 + "\n" + year3);

        br.close();
        bw.close();
    }
}
