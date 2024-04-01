package Silver4.Day103;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();
        while (N-- > 0) {
            String line = br.readLine();

            StringBuilder nums = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if ('0' <= ch && ch <= '9')
                    nums.append(ch);


                if (i == line.length() - 1 || ('0' > ch || ch > '9')){
                    if (nums.length() > 0) {
                        list.add(new BigInteger(nums.toString()));
                        nums.setLength(0);
                    }
                }
            }
        }

        Collections.sort(list);

        for (BigInteger num : list)
            bw.write(num + "\n");

        // 정규식 사용
//        List<BigInteger> paper = new ArrayList<>();
//        String[] line;
//        while (N-- > 0) {
//            line = br.readLine().split("\\D");
//            for (int i = 0; i < line.length; i++)
//                if (!line[i].equals(""))
//                    paper.add(new BigInteger(line[i]));
//        }
//
//        paper.sort(null);
//
//        for (BigInteger num : paper)
//            bw.write(num + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
