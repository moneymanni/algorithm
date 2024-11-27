package Silver5.Day75;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));
        int[] newArr = new int[set.size()];
        int i = 0;
        for (int num : set)
            newArr[i++] = num;

        Arrays.sort(newArr);

        for (int num : newArr)
            bw.write(num + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}
