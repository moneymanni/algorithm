package Day7;

import java.io.*;

public class BOJ10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int average = 0;
        for (int i = 0; i < 5; i++) {
            int student = Integer.parseInt(br.readLine().strip());
            average += student > 40 ? student : 40;
        }
        bw.write(String.valueOf(average/5));
        bw.close();
    }
}
