package Silver4.Day93;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] A = new int[sizeA];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
            hashMap.put(num, 1);
        }

        int[] B = new int[sizeB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = num;
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int cntA = 0;
        for (int i = 0; i < sizeA; i++) {
            int num = A[i];
            if (hashMap.get(num) == 1)
                cntA++;
        }

        int cntB = 0;
        for (int i = 0; i < sizeB; i++) {
            int num = B[i];
            if (hashMap.get(num) == 1)
                cntB++;
        }

        int sum = cntA + cntB;
        bw.write(sum + "");
    }
}
