package Silver1.Day161;

import java.io.*;
import java.util.*;

public class BOJ14225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] S = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            S[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(S));

        calculateSubSums(S, 0, 0, list);

        TreeSet<Integer> subSetSums = new TreeSet<>(list);

        int cnt = 1;
        for (int sum : subSetSums) {
            if (cnt != sum)
                break;
            cnt++;
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void calculateSubSums(Integer[] arr, int idx, int currSum, List<Integer> subSetSums) {
        if (idx == arr.length) {
            if (currSum != 0)
                subSetSums.add(currSum);
            return;
        }

        calculateSubSums(arr, idx + 1, currSum, subSetSums);
        calculateSubSums(arr, idx + 1, currSum + arr[idx], subSetSums);
    }
}
