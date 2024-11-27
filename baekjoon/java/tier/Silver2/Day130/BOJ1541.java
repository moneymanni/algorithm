package Silver2.Day130;

import java.io.*;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        String[] sub = line.split("-");
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < sub.length; i++) {
            int temp = 0;

            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++)
                temp += Integer.parseInt(add[j]);

            if (sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }

        bw.write(sum + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
