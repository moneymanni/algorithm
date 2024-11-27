package Day30;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(br.readLine());

        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            result.add(num % 42);
        }
        bw.write(result.size() + "");

        br.close();
        bw.close();
    }
}
