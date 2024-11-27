package Day10;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int difference = Integer.parseInt(st.nextToken());

        if (sum < difference)
            bw.write("-1");
        else {
            int A = (sum + difference) / 2;
            int B = (sum - difference) / 2;
            if (A + B == sum && A - B == difference)
                bw.write(A + " " + B);
            else
                bw.write("-1");
        }

        bw.flush();
        bw.close();
    }
}
