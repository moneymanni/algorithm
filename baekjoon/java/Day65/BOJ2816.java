package Day65;

import java.io.*;

public class BOJ2816 {
    public static final String CHANNEL_1 = "KBS1";
    public static final String CHANNEL_2 = "KBS2";
    public static final int ARROW_DOWN = 1;
    public static final int ARROW_UP = 2;
    public static final int CHANNEL_DOWN = 3;
    public static final int CHANNEL_UP = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] channel = new String[N];
        for (int i = 0; i < N; i++)
            channel[i] = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (channel[i].equals(CHANNEL_1)) {
                for (int j = i; j > 0; j--) {
                    result.append(CHANNEL_UP);
                    String temp = channel[j - 1];
                    channel[j - 1] = channel[j];
                    channel[j] = temp;
                }
                break;
            } else {
                result.append(ARROW_DOWN);
            }
        }

        if (!channel[1].equals(CHANNEL_2)) {
            for (int i = 0; i < N; i++) {
                if (channel[i].equals(CHANNEL_2)) {
                    for (int j = i; j > 1; j--) {
                        result.append(CHANNEL_UP);
                        String temp = channel[j - 1];
                        channel[j - 1] = channel[j];
                        channel[j] = temp;
                    }
                    break;
                } else {
                    result.append(ARROW_DOWN);
                }
            }
        }

        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
