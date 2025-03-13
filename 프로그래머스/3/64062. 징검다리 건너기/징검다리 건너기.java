import java.util.*;

class Solution {
    // 슬라이딩 윈도우를 쓴 이유 -> 직전 돌에서 갈 수 있는 선택지.
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i=0;i<stones.length;i++) {
            
            if (!deque.isEmpty() && deque.peekFirst() < i-k+1) { //슬라이딩 윈도우 범위를 벗어난 숫자
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) { // 앞으로의 모든 구간에서 답이 될수 없는 수는 남기지 않음
                deque.pollLast();
            }
            
            deque.addLast(i);
            
            if (i-k+1 >= 0) {
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }
        
        return answer;
    }
}