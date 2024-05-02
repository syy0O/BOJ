//TODO: stack 사용
// '(' : 스택에 push
// ')' : 스택 pop
// 만약, pop 할 것이 없음 -> false return
// 만약, 스택 안에 남은 것이 있다? -> false 리턴
// 없다-> true 리턴

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.addLast('(');
            }
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pollLast();
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}