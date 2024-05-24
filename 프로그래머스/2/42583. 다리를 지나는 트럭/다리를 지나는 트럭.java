import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights){
         Deque<Integer> queue = new ArrayDeque<>();

        int answer = 0; // 경과된 시간
        int cnt = 0; // 건넌 트럭의 개수
        int total = truck_weights.length;

        int idx = 0;
        int currWeightSum = 0;
        while (cnt < total) {
            answer++;

            if (queue.size() == bridge_length) {
                int w = queue.pollFirst();
                currWeightSum -= w;
                if (w != 0) {
                    cnt++;
                }
            }

            if (idx < total && currWeightSum + truck_weights[idx] <= weight) {
                currWeightSum += truck_weights[idx];
                queue.addLast(truck_weights[idx]);
                idx++;
                continue;
            }

            queue.addLast(0);
        }


        return answer;
    }
}