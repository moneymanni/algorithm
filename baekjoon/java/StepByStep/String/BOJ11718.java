package StepByStep.String;

import java.io.*;

public class BOJ11718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while ((input = br.readLine()) != null) {
            bw.write(input);
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
