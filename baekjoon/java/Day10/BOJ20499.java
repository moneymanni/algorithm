package Day10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ20499 {
    public static final String REAL = "gosu";
    public static final String FAKE = "hasu";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> kda = new ArrayList<>();
        String[] line = br.readLine().split("/");
        for (String str : line)
            kda.add(Integer.parseInt(str));

        bw.write(kda.get(0) + kda.get(2) < kda.get(1) || kda.get(1) == 0 ? FAKE : REAL);

        bw.flush();
        bw.close();
    }
}
