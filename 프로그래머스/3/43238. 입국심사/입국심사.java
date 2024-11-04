class Solution {
    
    
    private final long MAX = 1_000_000_000_000_000_000L;
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = MAX;
        
        while (left < right) {
            long mid = (left + right) / 2;
            if (isPossible(mid, n, times)) {
                right = mid;  
            }
            else {
                left = mid + 1;
            } 
        }
        
        answer = left;
        
        return answer;
    }
    
    public boolean isPossible(long total, int n, int[] times) {
        long sum = 0;
        for (int i=0;i<times.length;i++){
            sum += total / times[i];
        }
       
        return sum >= n;
    }
}