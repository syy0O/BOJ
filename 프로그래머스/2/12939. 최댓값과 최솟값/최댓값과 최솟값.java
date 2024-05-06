import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        
        List<Integer> numbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(numbers);
        
        String answer = numbers.get(0) + " " + numbers.get(numbers.size()-1);
        
        
        return answer;
    }
}