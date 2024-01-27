import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answers = new ArrayList<>();
        Deque<Integer> remainProgress = new ArrayDeque<>();
        Deque<Integer> progressSpeeds = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            remainProgress.addLast(progresses[i]);
            progressSpeeds.addLast(speeds[i]);
        }

        while (!remainProgress.isEmpty()) {

            int currSize = remainProgress.size();
            for (int i = 0; i < currSize; i++) {
                int progress = remainProgress.pollFirst();
                int speed = progressSpeeds.pollFirst();

                remainProgress.addLast(progress + speed);
                progressSpeeds.addLast(speed);
            }

            int cnt = 0;
            while(!remainProgress.isEmpty() && remainProgress.peekFirst() >= 100) {
                remainProgress.pollFirst();
                progressSpeeds.pollFirst();
                cnt++;
            }

            if (cnt != 0) {
                answers.add(cnt);
            }
        }

        int[] answer = new int[answers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }
}