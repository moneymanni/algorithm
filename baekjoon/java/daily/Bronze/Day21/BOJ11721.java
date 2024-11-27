package Day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            if (cnt == 10) {
                sb.append("\n");
                cnt = 0;
            }
            sb.append(line.charAt(i));
            cnt++;
        }
        System.out.println(sb);

        br.close();
    }
}
