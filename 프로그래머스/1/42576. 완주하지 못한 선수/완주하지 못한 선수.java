// 1명이상 - 10만명 이하
// O(NlogN)
// 두번 반복문 도는 순간 끝남.

// 어차피 participant 배열 만큼은 돌아야함 (100000번)
import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 동명이인이 있을 수 있음 -> 키로만 구분하면 안되고 값으로 구분해야함.
        HashMap<String, Integer> completions = new HashMap<>();
        for (int i=0;i<completion.length;i++) {
            String key = completion[i];
            completions.put(key, completions.getOrDefault(key, 0) + 1);
        }
        
      
        // participant가 키에 있는지 확인. 없으면 바로 나가리.
        for (int i=0;i<participant.length;i++) {
            String key = participant[i];
            
            // 아예 키가 존재하지 않거나, 키의 값이 0일 때
            if (!completions.containsKey(key) || completions.get(key) == 0) {
                answer = key;
                break;
            }
            
            completions.put(key, completions.get(key) - 1);
        }
       
        
        
        return answer;
    }
}