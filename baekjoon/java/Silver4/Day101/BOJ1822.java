package Silver4.Day101;

import java.io.*;
import java.util.*;

public class BOJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[nA];
        for (int i = 0; i < nA; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] B = new int[nB];
        for (int i = 0; i < nB; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nB; i++)
            set.add(B[i]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nA; i++) {
            if (!set.contains(A[i]))
                list.add(A[i]);
        }

        Collections.sort(list);

        if (list.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(list.size() + "\n");
            for (int i = 0; i < list.size(); i++)
                bw.write(list.get(i) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
