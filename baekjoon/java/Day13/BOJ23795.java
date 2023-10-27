package Day13;

import java.io.*;

public class BOJ23795 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int sum = 0;
            while (true) {
                int money = Integer.parseInt(br.readLine());
                if (money == -1) break;
                sum += money;
            }
            bw.write(sum + "");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
