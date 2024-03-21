package Silver4.Day94;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numOfSwitches = Integer.parseInt(br.readLine());
        int[] states = new int[numOfSwitches+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numOfSwitches; i++)
            states[i] = Integer.parseInt(st.nextToken());

        int numOfStudents = Integer.parseInt(br.readLine());
        while (numOfStudents-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = num; i <= numOfSwitches; i += num)
                    states[i] ^= 1;
            } else {
                int start = num - 1;
                int end = num + 1;
                while (start >= 1 && end <= numOfSwitches) {
                    if (states[start] != states[end])
                        break;
                    start--; end++;
                }
                start++; end--;

                for (int i = start; i <= end; i++)
                    states[i] ^= 1;
            }
        }

        for (int i = 1; i <= numOfSwitches; i++) {
            bw.write(states[i] + " ");
            if (i % 20 == 0)
                bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
