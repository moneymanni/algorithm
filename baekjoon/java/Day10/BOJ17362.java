package Day10;

import java.io.*;

public class BOJ17362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int k = n % 8;
        switch (k) {
            case 1:
                bw.write("1");
                break;
            case 0:
            case 2:
                bw.write("2");
                break;
            case 3:
            case 7:
                bw.write("3");
                break;
            case 4:
            case 6:
                bw.write("4");
                break;
            default:
                bw.write("5");
                break;
        }

        bw.flush();
        bw.close();
    }
}
