class Solution {
    // 구해야하는 것: 퍼즐들을 제한시간내에 해결할 수 있는 최소 숙련도 구하기
    // 퍼즐의 순서는 유지해야함
    
    // 숙련도 - level 
    // 퍼즐 난이도 : diff, 현재 퍼즐 소요시간 : time_cur, 이전 퍼즐 소요시간 : time_prev
    
    // n <= 30000 
    // O(NlogN) or O(logN)
    // level에 대한 이분탐색
    // level의 최소 : diff의 최소 -> 1 , level의 최대 -> diff의 최대값인 100000
    private int[] puzzleDiffs;
    private int[] solveTimes;
    
    private final int MAX = 100_000;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        puzzleDiffs = diffs;
        solveTimes = times;
        
        
        int start = 1;
        int end = MAX;
        
        while (start < end) {
            int level = (start+end) / 2;
            if (isPossible(level, limit)){
                end = level;
            }
            else {
                start = level+1;
            }
        }
        
        int answer = start;
        
        return answer;
    }
    
    public boolean isPossible(int level, long limit) {
        
        long totalTime = 0;
        int n = puzzleDiffs.length;
        
        for (int i=0;i<n;i++) {
            if (puzzleDiffs[i] <= level) {
                totalTime += solveTimes[i];
                continue;
            }
            
            long gap = puzzleDiffs[i] - level;
            long curr = (solveTimes[i] + solveTimes[i-1]) * gap + solveTimes[i];
            totalTime += curr;
        }
        
        return totalTime <= limit;
    }
}