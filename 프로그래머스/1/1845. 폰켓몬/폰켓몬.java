// N마리 폰켓몬 중 -> N/2 마리
// 종류가 같으면 같은 번호
// 최대한 많은 종류의 폰켓몬 => N/2 마리

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int totalCnt = nums.length / 2;
        
        HashMap<Integer, Integer> monster = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            monster.put(nums[i], monster.getOrDefault(nums[i], 0) + 1);
        }
        
        // if 종류 수가 N/2 보다 같거나 많음 => 답: N/2
        if (monster.size() >= totalCnt) {
            answer = totalCnt;
        }
            
        // 아니라면 => 폰켓몬 종류의 개수.
        else {
            answer = monster.size();
        }
        
        return answer;
    }
}