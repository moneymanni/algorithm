package Day66;

import java.io.*;

public class BOJ15947 {
    public static String babySukhwan = "baby sukhwan tururu turu " +
            "very cute tururu turu " +
            "in bed tururu turu " +
            "baby sukhwan";
    public static final String RU = "ru";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = babySukhwan.split(" ");

        int remainder = N % arr.length;
        String str = remainder == 0 ? arr[arr.length - 1] : arr[remainder - 1];

        StringBuilder result = new StringBuilder(str);
        if (str.equals("tururu") || str.equals("turu")) {
            int cnt = N / arr.length;
            if ((str.equals("tururu") && cnt < 3) || (str.equals("turu") && cnt < 4)) {
                while (cnt-- > 0) {
                    result.append(RU);
                }
            } else {
                result.setLength(0);
                cnt = str.equals("tururu") ? cnt + 2 : cnt + 1;
                result.append("tu+ru*").append(cnt);
            }
        }
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
