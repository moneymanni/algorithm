package Day9;

import java.io.*;

public class BOJ10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int month = Integer.parseInt(br.readLine().strip());
        int day = Integer.parseInt(br.readLine().strip());

        if (month == 2 && day == 18)
            bw.write("Special");
        else if ((month >= 2 && day > 18) || month > 2)
            bw.write("After");
        else
            bw.write("Before");

        bw.flush();
        bw.close();
    }
}
