// TODO: 해시맵 이용
// 1) 폰켓몬의 종류를 key로하고, 마리수를 value로 하는 해시맵 생성
// 2) N/2 개 선택
    // Key 개수 <= N/2 -> key 개수
    // Key 개수 > N/2 -> N/2

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<N;i++) {
            int type = nums[i];
            int cnt = hashMap.getOrDefault(type,0) + 1;
            hashMap.put(type, cnt);
        }
        
    
        int answer = (hashMap.size() <= N/2) ? hashMap.size() : N/2;
       
        return answer;
    }
}