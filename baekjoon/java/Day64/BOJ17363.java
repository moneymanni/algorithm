package Day64;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] box = new char[N][M];
        for (int i = 0; i < N; i++)
            box[i] = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                char prev = box[j][i];
                char curr = ' ';

                switch (prev) {
                    case '-':
                        curr = '|';
                        break;
                    case '|':
                        curr = '-';
                        break;
                    case '/':
                        curr = '\\';
                        break;
                    case '\\':
                        curr = '/';
                        break;
                    case '^':
                        curr = '<';
                        break;
                    case '<':
                        curr = 'v';
                        break;
                    case 'v':
                        curr = '>';
                        break;
                    case '>':
                        curr = '^';
                        break;
                    default:
                        curr = prev;
                        break;
                }

                sb.append(curr);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
