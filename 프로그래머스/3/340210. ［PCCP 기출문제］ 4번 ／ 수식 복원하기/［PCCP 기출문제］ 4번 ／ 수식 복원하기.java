import java.util.*;  

   
/* 정규표현식

    //s : 공백
    //s* : 공백이 0번 이상 반복된다(= 공백이 있을수도, 없을 수도 있다)
    
*/

class Solution {
    static List<String> incomplete; 

    public String[] solution(String[] expressions) {
        incomplete = new ArrayList<>();  // 불완전한 수식을 저장할 ArrayList

        for (String expression : expressions) {
            if (expression.charAt(expression.length() - 1) == 'X') {
                incomplete.add(expression);
            }
        }

        List<Integer> radixList = new ArrayList<>();  // 가능한 진법(radix)을 저장

        for (int radix = 2; radix < 10; radix++) {
            if (validate(radix, expressions)) {
                radixList.add(radix);
            }
        }

        String[] answer = new String[incomplete.size()];  

 
        for (int i = 0; i < incomplete.size(); i++) {
            String expression = incomplete.get(i);  
            String[] splits = expression.split("\\s*=\\s*");  
            Set<String> resultSet = new HashSet<>();  
            String result = "";  

            
            for (int radix : radixList) {
                try {
                    int value = calc(splits[0], radix);  
                    result = Integer.toString(value, radix); 
                    resultSet.add(result); 
                } catch (NumberFormatException e) {
                    continue;  
                }
            }

            if (resultSet.size() == 1) {
                answer[i] = splits[0] + " = " + result;
            } else {
                answer[i] = splits[0] + " = ?";
            }
        }

        return answer;  // 최종적으로 불완전한 수식의 결과가 담긴 answer 배열을 반환합니다.
    }

  
    private boolean validate(int radix, String[] expressions) {
        for (String expression : expressions) {
            try {
             
                String[] splits = expression.split("\\s*=\\s*"); 
                int result = calc(splits[0], radix);  // '=' 왼쪽 수식 계산
                
                if (!splits[1].equals("X")) {
                    int expected = Integer.parseInt(splits[1], radix);  
                    
                    if (result != expected) {
                        return false;  
                    }
                }
            } catch (NumberFormatException e) {
                return false;  
            }
        }
        return true;
    }

   
    private int calc(String expression, int radix) {
        String[] splits = expression.split(" ");  
        int operand1 = Integer.parseInt(splits[0], radix);  
        String operator = splits[1];  // 연산자를 가져옵니다.
        int operand2 = Integer.parseInt(splits[2], radix); 

        if (operator.equals("+")) {
            return operand1 + operand2;
        } else {
            return operand1 - operand2;
        }
    }
}
