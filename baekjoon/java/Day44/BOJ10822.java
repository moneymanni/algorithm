package Day44;

import java.io.*;

public class BOJ10822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strNums = br.readLine().split(",");

        long sum = 0;
        for (int i = 0; i < strNums.length; i++)
            sum += Integer.parseInt(strNums[i]);

        bw.write(String.format("%d", sum));

        bw.flush();
        br.close();
        bw.close();
    }
}
