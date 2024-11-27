package Silver3.Day124;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        Stack<int[]> taskStack = new Stack<>();
        int[] ongoingTask = {-1, -1};  // 과제의 만점, 해결 시간
        int sumScore = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int perfectScore = -1;
            int takenTime = -1;

            if (option == 1) {
                perfectScore = Integer.parseInt(st.nextToken());
                takenTime = Integer.parseInt(st.nextToken());
            }

            ongoingTask[1]--;

            if (ongoingTask[1] == 0) {
                sumScore += ongoingTask[0];

                if (!taskStack.isEmpty()) {
                    int[] newTask = taskStack.pop();
                    ongoingTask[0] = newTask[0];
                    ongoingTask[1] = newTask[1];
                } else {
                    ongoingTask[0] = -1;
                    ongoingTask[1] = -1;
                }
            }

            if (ongoingTask[0] == -1 && option == 1) {
                ongoingTask[0] = perfectScore;
                ongoingTask[1] = takenTime;
            } else if (option == 1){
                taskStack.push(new int[]{ongoingTask[0], ongoingTask[1]});
                ongoingTask[0] = perfectScore;
                ongoingTask[1] = takenTime;
            }
        }

        ongoingTask[1]--;
        if (ongoingTask[1] == 0)
            sumScore += ongoingTask[0];

        bw.write(sumScore + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
