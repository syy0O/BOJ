import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int K) {
         int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K) {

            int first = pq.poll();
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            int sec = pq.poll();
            int newFood = first + sec * 2;

            pq.add(newFood);
            
            answer++;
        }
        return answer;
    }
}