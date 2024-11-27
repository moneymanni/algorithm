package Day48;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] sizeOfFiles = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            sizeOfFiles[i] = Long.parseLong(st.nextToken());
        long sizeOfCluster = Long.parseLong(br.readLine());

        long result = 0;
        for (int i = 0; i < N; i++) {
            long sizeOfFile = sizeOfFiles[i];
            long num = 0;
            if (sizeOfFile == 0) {
                continue;
            } else if (sizeOfFile <= sizeOfCluster) {
                num = 1;
            } else {
                num = sizeOfFile % sizeOfCluster == 0 ?
                        sizeOfFile / sizeOfCluster :
                        sizeOfFile / sizeOfCluster + 1;
            }
            result += num * sizeOfCluster;
        }

        bw.write(result + "");

        bw.flush();
        br.close();
        bw.close();
    }
}
