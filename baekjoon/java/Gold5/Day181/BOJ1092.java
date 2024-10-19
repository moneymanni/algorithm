package Gold5.Day181;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> craneWeight = new ArrayList<>();
        List<Integer> boxWeight = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            craneWeight.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            boxWeight.add(Integer.parseInt(st.nextToken()));

        craneWeight.sort(Collections.reverseOrder());
        boxWeight.sort(Collections.reverseOrder());

        if(craneWeight.get(0)<boxWeight.get(0)){
            bw.write("-1");
        } else {
            int cnt = 0;

            while (!boxWeight.isEmpty()) {
                int boxIdx = 0;
                int craneIdx = 0;

                while (craneIdx < N) {
                    if (boxIdx == boxWeight.size()) {
                        break;
                    } else if (craneWeight.get(craneIdx) >= boxWeight.get(boxIdx)) {
                        boxWeight.remove(boxIdx);
                        craneIdx++;
                    } else {
                        boxIdx++;
                    }
                }

                cnt++;
            }

            bw.write(String.valueOf(cnt));
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
