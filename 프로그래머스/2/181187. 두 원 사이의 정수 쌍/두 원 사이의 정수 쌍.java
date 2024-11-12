// 2차원 좌표로 접근하는 순간 -> 시간초과
// 수학
// 1사분면 * 4
class Solution {
    public long solution(int r1, int r2) {
        long answer = 4; // 큰 원이 수직선과 만나는 좌표 4개
     
        for (int i=1;i<r2;i++) {
            
            int minY = (int) Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
            int maxY = (int) Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)));
            
            answer += (maxY - minY + 1) * 4; // (r1,0) 제외 하고 나머지 개수
        }
        
        return answer;
    }
}