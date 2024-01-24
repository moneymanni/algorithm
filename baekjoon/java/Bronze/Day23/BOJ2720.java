package Day23;

import java.io.*;

public class BOJ2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] C = new int[T];
        for (int i = 0; i < T; i++)
            C[i] = Integer.parseInt(br.readLine());

        // 쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수
        for (int i = 0; i < T; i++) {
            int quarter = C[i]/25;
            int dime = C[i]%25/10;
            int nickel = C[i]%25%10/5;
            int penny = C[i]%25%10%5;
            bw.write(quarter + " " + dime + " " + nickel + " " + penny);
        }

        br.close();
        bw.close();
    }
}
