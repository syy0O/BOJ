import java.util.HashMap;


class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> kind = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String[] curr = clothes[i];
            kind.put(curr[1], kind.getOrDefault(curr[1], 0) + 1);
        }

        for (String s : kind.keySet()) {
            answer *= kind.get(s) + 1; // 안 입었을 경우까지 더함
        }

        return answer - 1;
    }
   
}