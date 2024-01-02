package Day56;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2947 {
    public static final int PIECES_OF_WOOD = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[PIECES_OF_WOOD];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 버블 정렬 문제?
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    for (int num : nums)
                        bw.write(num + " ");
                    bw.write("\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
