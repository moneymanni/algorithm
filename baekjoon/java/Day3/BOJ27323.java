package Day3;

import java.io.*;

public class BOJ27323 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int A = Integer.parseInt(br.readLine().strip());
            int B = Integer.parseInt(br.readLine().strip());
            String result = String.valueOf(A * B);

            bw.write(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
