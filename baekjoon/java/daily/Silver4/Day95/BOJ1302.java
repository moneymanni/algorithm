package Silver4.Day95;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> books = new HashMap<>();
        while (N-- > 0) {
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0) + 1);
        }

        String bestSellingBook = "";
        int maxNum = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> book : books.entrySet()) {
            String name = book.getKey();
            Integer num = book.getValue();

            if (num > maxNum) {
                bestSellingBook = name;
                maxNum = num;
            } else if (num == maxNum) {
                if (name.compareTo(bestSellingBook) < 0)
                    bestSellingBook = name;
            }
        }

        bw.write(bestSellingBook);

        br.close();
        bw.flush();
        bw.close();
    }
}
