package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(",");
            System.out.println(Integer.parseInt(line[0]) + Integer.parseInt(line[1]));
        }

        br.close();
    }
}
