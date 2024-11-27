package Silver2.Day145;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        VirtualOpeningCeremony voc = new VirtualOpeningCeremony(S, E, Q);

        String input;

        while((input = br.readLine()) != null) {
            String[] info = input.split(" ");
            String time = info[0];
            String name = info[1];

            voc.chat(name, time);
        }

        bw.write(voc.getAttendanceCount() + "");

        br.close();
        bw.flush();
        bw.close();
    }

    static class VirtualOpeningCeremony {
        private String VOCStartTime;
        private String VOCEndTime;
        private String streamingEndTime;

        private HashMap<String, ArrayList<String>> userMap;
        private HashSet<String> beforeSet;
        private HashSet<String> afterSet;

        public VirtualOpeningCeremony(String VOCStartTime, String VOCEndTime, String streamingEndTime) {
            this.VOCStartTime = VOCStartTime;
            this.VOCEndTime = VOCEndTime;
            this.streamingEndTime = streamingEndTime;

            userMap = new HashMap<>();
            beforeSet = new HashSet<>();
            afterSet = new HashSet<>();
        }

        public void chat(String name, String chatTime) {
            if (!userMap.containsKey(name))
                userMap.put(name, new ArrayList<>());

            userMap.get(name).add(chatTime);

            if (VOCStartTime.compareTo(chatTime) >= 0)
                beforeSet.add(name);
            else if (VOCEndTime.compareTo(chatTime) <= 0 && streamingEndTime.compareTo(chatTime) >= 0)
                afterSet.add(name);
        }

        public int getAttendanceCount() {
            int cnt = 0;

            for (String name : userMap.keySet()) {
                if (beforeSet.contains(name) && afterSet.contains(name))
                    cnt++;
            }

            return cnt;
        }
    }
}
