import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
       String answer = "";
        HashMap<String, Integer> countOfName = new HashMap<>();
        for (String s : completion) {
            countOfName.put(s, countOfName.getOrDefault(s, 0) + 1);
        }

        
        for (String s : participant) {
            if (!countOfName.containsKey(s)) {
                answer = s;
                break;
            }

            countOfName.put(s, countOfName.get(s) - 1);
            
            if (countOfName.get(s) == 0) {
                countOfName.remove(s);
            }
        }
        
        return answer;
    }
}