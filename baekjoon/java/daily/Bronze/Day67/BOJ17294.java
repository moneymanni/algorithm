package Day67;

import java.io.*;

public class BOJ17294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] nums = br.readLine().toCharArray();

        boolean isCuteNum = true;
        int diff = nums.length > 1 ? nums[0] - nums[1] : 0;
        for (int i = 2; i < nums.length; i++) {
            if (diff != nums[i - 1] - nums[i]) {
                isCuteNum = false;
                break;
            }
        }

        bw.write(isCuteNum ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!" : "흥칫뿡!! <(￣ ﹌ ￣)>");

        br.close();
        bw.flush();
        bw.close();
    }
}
