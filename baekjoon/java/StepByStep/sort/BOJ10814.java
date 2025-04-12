package StepByStep.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(i, name, age);
        }

        Arrays.sort(members);

        for (Member member : members) {
            bw.write(String.format("%d %s\n", member.age, member.name));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static class Member implements Comparable<Member> {
        int idx;
        String name;
        int age;

        public Member(int idx, String name, int age) {
            this.idx = idx;
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Member obj) {
            if (this.age != obj.age)
                return this.age - obj.age;

            return this.idx - obj.idx;
        }
    }
}
