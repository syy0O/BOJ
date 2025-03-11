class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(stones, k, mid)) {
                left = mid + 1;
                answer = Math.max(answer,mid);
            }
            else {
                right = mid-1;   
            }
        }
    
        return answer;
    }
    
    
    public boolean isPossible(int[] stones, int k , int target) {
        boolean flag = true;
        
        int skip = 0;
        for (int stone : stones) {
            if (stone < target) {
                skip++;
            }
            else {
                skip = 0;
            }
            
            if (skip == k) {
                return false;
            }
        }
        
        return flag;
    }
}