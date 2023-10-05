package Day10;

import java.io.*;

public class BOJ13752 {
    public static final String HISTOGRAM_BAR = "=";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int bar = Integer.parseInt(br.readLine());
            for (int j = 0; j < bar; j++)
                bw.write(HISTOGRAM_BAR);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
