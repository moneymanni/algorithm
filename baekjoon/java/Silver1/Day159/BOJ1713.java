package Silver1.Day159;

import java.io.*;
import java.util.*;

public class BOJ1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int stuNum = Integer.parseInt(br.readLine());

        PhotoFrames frames = new PhotoFrames(N);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <stuNum; i++) {
            int stuId = Integer.parseInt(st.nextToken());
            frames.put(stuId);
        }

        List<Integer> list = frames.getSortedList();

        for (int i : list)
            bw.write(i + " ");

        br.close();
        bw.flush();
        bw.close();
    }

    static class PhotoFrames {
        int cnt;
        int seqNum;
        Map<Integer, Candidate> frameMap;

        public PhotoFrames (int cnt) {
            this.cnt = cnt;
            seqNum = 1;
            frameMap = new HashMap<>();
        }

        public void put (int stuId) {
            if (frameMap.containsKey(stuId)) {
                frameMap.get(stuId).cnt++;
            } else {
                if (frameMap.size() == cnt) {
                    int findId = findStuIdForDeletion();
                    frameMap.remove(findId);
                }
                frameMap.put(stuId, new Candidate(stuId, 1, seqNum++));
            }
        }

        private int findStuIdForDeletion () {
            Candidate candidate = null;

            for (Candidate currCandidate : frameMap.values()) {
                if (candidate == null || candidate.compareTo(currCandidate) > 0)
                    candidate = currCandidate;
            }

            return candidate != null ? candidate.stuId : -1;
        }

        public List<Integer> getSortedList () {
            List<Integer> list = new ArrayList<>(frameMap.keySet());

            Collections.sort(list);

            return list;
        }
    }

    static class Candidate implements Comparable<Candidate> {
        int stuId;
        int cnt;
        int seqNum;

        public Candidate (int stuId, int cnt, int seqNum) {
            this.stuId = stuId;
            this.cnt = cnt;
            this.seqNum = seqNum;
        }

        @Override
        public int compareTo(Candidate obj) {
            if (this.cnt != obj.cnt)
                return this.cnt - obj.cnt;
            else
                return this.seqNum - obj.seqNum;
        }
    }
}
