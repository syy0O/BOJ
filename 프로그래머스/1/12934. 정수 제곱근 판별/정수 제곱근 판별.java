class Solution {
    public long solution(long n) {
        
        long answer = 0;
        
        double sqrt = Math.sqrt(n);
        if (sqrt - (int)sqrt != 0) {
            answer = -1;
        }
        else {
            answer = (long)Math.pow((int)sqrt+1,2);
        }
        
            
        return answer;
    }
}