package Day7;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        int[] nums = new int[3];
//        for (int i = 0; i < nums.length; i++)
//            nums[i] = Integer.parseInt(st.nextToken());
//
//        Arrays.sort(nums);
//
//        for (int num : nums)
//            bw.write(String.valueOf(num) + " ");
//        bw.flush();
//        bw.close();


//        int[] nums = new int[3];
//        for (int i = 0; i < nums.length; i++)
//            nums[i] = Integer.parseInt(st.nextToken());
//
//        Arrays.stream(nums)
//                .sorted()
//                .forEach(num -> System.out.print(num + " "));


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 3; i++)
            priorityQueue.add(Integer.parseInt(st.nextToken()));
        while (!priorityQueue.isEmpty())
            bw.append(priorityQueue.remove() + " ");
        bw.flush();
        bw.close();
    }
}
