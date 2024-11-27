package Day13;

import java.io.*;

public class BOJ13985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] list = br.readLine().split(" ");
        int a = Integer.parseInt(list[0]);
        int b = Integer.parseInt(list[2]);
        int c = Integer.parseInt(list[4]);

        String result = a + b == c ? "YES" : "NO";
        bw.write(result);

        br.close();
        bw.close();
    }
}
