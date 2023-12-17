import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    private static TreeMap<Integer, Candidate> frames;
    private static class Candidate {
        int time;
        int recommendCnt;

        public Candidate(int time, int recomandCnt) {
            this.time = time;
            this.recommendCnt = recomandCnt;
        }

        public void addRecommendCnt(){
            recommendCnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine()); // 추천 횟수

        frames = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int candidateNum = Integer.parseInt(st.nextToken());

            if (frames.size() == N && !frames.containsKey(candidateNum)) {
                frames.remove(findMinRecommend());
                frames.put(candidateNum, new Candidate(i, 1));
                continue;
            }

            if (frames.containsKey(candidateNum)) {
                Candidate c = frames.get(candidateNum);
                c.addRecommendCnt();
                frames.put(candidateNum, c);
            }
            else {
                Candidate c = new Candidate(i, 1);
                frames.put(candidateNum,c);
            }
        }

        for (Integer number : frames.keySet()) {
            bw.write(number+" ");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    public static int findMinRecommend() {
        int minCount = Integer.MAX_VALUE;
        for (Candidate value : frames.values()) {
            if (minCount > value.recommendCnt) {
                minCount = value.recommendCnt;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int result = 0;
        for (Integer idx : frames.keySet()) {
            Candidate c = frames.get(idx);
            if (c.recommendCnt == minCount && minTime > c.time) {
                minTime = c.time;
                result = idx;
            }
        }

        return result;
    }

}
