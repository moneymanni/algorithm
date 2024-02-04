package Silver5.Day73;

import java.io.*;

public class BOJ17478 {
    public static final String RECURSION_CHAR = "____";
    public static final String MONOLOGUE = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    public static final String STUDENT_QUESTION = "\"재귀함수가 뭔가요?\"\n";
    public static final String PROFESSOR_STORY_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    public static final String PROFESSOR_STORY_2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    public static final String PROFESSOR_STORY_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    public static final String PROFESSOR_ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    public static final String PROFESSOR_CLOSING_REMARK = "라고 답변하였지.\n";
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        result.append(MONOLOGUE);
        automaticResponseChatbot(N, 0);
        bw.write(result.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void automaticResponseChatbot (int num, int cnt) {
        String indent = RECURSION_CHAR.repeat(cnt);

        result.append(indent).append(STUDENT_QUESTION);
        if (num == 0) {
            result.append(indent).append(PROFESSOR_ANSWER);
        } else {
            result.append(indent).append(PROFESSOR_STORY_1);
            result.append(indent).append(PROFESSOR_STORY_2);
            result.append(indent).append(PROFESSOR_STORY_3);
            automaticResponseChatbot(num - 1, cnt + 1);
        }
        result.append(indent).append(PROFESSOR_CLOSING_REMARK);
    }
}
