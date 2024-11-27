package Silver5.Day79;

import java.io.*;

public class BOJ9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String result = "";
        if (N % 2 == 0)
            result = "SK";
        else
            result = "CY";

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}
