class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) { // 한자리수씩 떼어가면서 볼 거임
            int last = storey % 10; // 1의 자리
            
            if (last > 5) {
                storey = (storey + 10-last) / 10;
                answer += 10-last;
            }
            else if (last < 5) {
                storey = (storey - last) / 10;
                answer += last;
            }
            else {
                int plus = (storey + 10-last) / 10; // 올림
                int minus = (storey - last) / 10; // 버림
                
                int plusCnt = plus % 10 >= 5 ? 10 - plus % 10 : plus % 10; 
                int minusCnt = minus % 10; 
                
                storey =  plusCnt < minusCnt ? plus : minus;
                answer += last;
            }
        }
        
        
        return answer;
    }
}