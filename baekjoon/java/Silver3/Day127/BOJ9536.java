package Silver3.Day127;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String cries = " " + br.readLine();

            String line;
            while (!(line = br.readLine()).equals("what does the fox say?")) {
                String[] tokens = line.split(" ");
                cries = cries.replaceAll("\\s" + tokens[2], "");
            }
            sb.append(cries.trim()).append('\n');
        }

        bw.write(sb.toString().trim());


        // 2
//        int T = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//
//        while (T-- > 0) {
//            String[] cries = br.readLine().split(" ");
//
//            List<String> other = new ArrayList<>();
//            List<String> cryList = new ArrayList<>();
//
//            String line;
//
//            while (!(line = br.readLine()).equals("what does the fox say?"))
//                other.add(line.split(" ")[2]);
//
//            for (int i = 0; i < cries.length; i++) {
//                if (!other.contains(cries[i]))
//                    cryList.add(cries[i]);
//            }
//
//            for (int i = 0; i < cryList.size(); i++)
//                sb.append(cryList.get(i)).append(' ');
//            sb.append('\n');
//        }
//        bw.write(sb.toString().trim());

        br.close();
        bw.flush();
        bw.close();
    }
}
