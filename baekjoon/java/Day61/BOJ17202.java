package Day61;

import java.io.*;

public class BOJ17202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            sb.append(A.charAt(i)).append(B.charAt(i));
        }

        String prov = sb.toString();
        while (true) {
            sb.setLength(0);
            for (int i = 0; i < prov.length() - 1; i++) {
                int num = Integer.parseInt(String.valueOf(prov.charAt(i)))
                        + Integer.parseInt(String.valueOf(prov.charAt(i + 1)));
                String numStr = String.valueOf(num);
                sb.append(numStr.charAt(numStr.length() - 1));

            }
            prov = sb.toString();

            if (prov.length() == 2)
                break;
        }

        bw.write(prov);

        br.close();
        bw.flush();
        bw.close();
    }
}
