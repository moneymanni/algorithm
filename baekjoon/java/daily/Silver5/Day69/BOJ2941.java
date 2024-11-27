package Silver5.Day69;

import java.io.*;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        int result = countCroatiaAlphabets(line);
        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int countCroatiaAlphabets (String str) {
        String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int len = str.length();
        int cnt = 0;
        int idx = 0;
        do {
            char ch = str.charAt(idx);

            if (idx < len - 1) {
                StringBuilder sb = new StringBuilder();
                switch (ch) {
                    case 'c': case 'd': case 'l':
                    case 'n': case 's': case 'z':
                        sb.append(ch).append(str.charAt(idx + 1));

                        if (sb.toString().equals("dz") && idx < len - 2) {
                            sb.append(str.charAt(idx + 2));

                            if (sb.toString().equals(croatiaAlphabets[2])) {
                                idx += 2;
                            }
                        } else {
                            for (String alpha : croatiaAlphabets) {
                                if (sb.toString().equals(alpha)) {
                                    idx++;
                                    break;
                                }
                            }
                        }
                    default:
                        cnt++;
                        break;
                }
                sb.setLength(0);
            } else {
                cnt++;
            }
        } while (++idx < len);

        return cnt;
    }
}
