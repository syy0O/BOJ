import java.util.*;

class Solution {
    
    private static class Ball {
        private int x, y;
        
        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static Ball origin;
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        origin = new Ball(startX,startY);
        
        for (int i=0;i<balls.length;i++) {
            answer[i] = getMinDis(m,n,new Ball(balls[i][0],balls[i][1]));
        }
        
        return answer;
    }
    
    
    public static int getMinDis(int m, int n, Ball target){
        int min = Integer.MAX_VALUE; 
        
        List<Ball> candidate = new ArrayList<>();
        
        // 위쪽 이동 (y=n 대칭이동)
        if (!(origin.x == target.x && origin.y < target.y)) {
            candidate.add(new Ball(target.x, 2*n-target.y));
        }
        
        // 아래쪽 이동 (y=0 대칭이동)
        if (!(origin.x == target.x && origin.y > target.y)) {
             candidate.add(new Ball(target.x, -target.y));
        }
        
        // 왼쪽 이동 (x=0 대칭이동)
        if (!(origin.y == target.y && origin.x > target.x)) {
             candidate.add(new Ball(-target.x, target.y));
        }
        
        
        // 오른쪽 이동 (x=m 대칭이동)
        if (!(origin.y == target.y && origin.x < target.x)) {
             candidate.add(new Ball(2*m - target.x, target.y));
        }
        
        for (Ball now : candidate) {
            int xAbs = Math.abs(origin.x - now.x);
            int yAbs = Math.abs(origin.y - now.y);
            
            min = Math.min(min, (int)(Math.pow(xAbs,2) + Math.pow(yAbs,2)));
        }
        
        
        return min;
    }
}