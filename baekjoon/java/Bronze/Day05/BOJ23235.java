package Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ23235 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int cnt = 1;

            while (true) {
                String str = br.readLine();

                if (str.equals("0"))
                    break;

                sb.append("Case ").append(cnt++).append(": Sorting... done!").append("\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
