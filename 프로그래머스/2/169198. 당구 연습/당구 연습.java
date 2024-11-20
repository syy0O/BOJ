class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i=0;i<balls.length;i++) {
            
            int dist = Integer.MAX_VALUE;
            
            int x = balls[i][0];
            int y = balls[i][1];
            
            // y = 0 대칭
            if (startX != x || y >= startY) {
                dist = Math.min((int)(Math.pow(startX - x, 2) + Math.pow(-y-startY, 2)), dist);
            }
           
            // y = m 대칭
            if (startX != x || y <= startY) {
                dist = Math.min((int)(Math.pow(startX - x, 2) + Math.pow(2*n-y-startY, 2)), dist);
            }
            
            // x = 0 대칭
            if (startY != y || x >= startX) {
                dist = Math.min((int)(Math.pow(-x - startX, 2) + Math.pow(y-startY, 2)), dist);
            }
            
            // x = m 대칭
            if (startY != y || x <= startX) {
                dist = Math.min((int)(Math.pow(2*m-x - startX, 2) + Math.pow(y-startY, 2)), dist);
            }

            answer[i] = dist;
        }
        
        return answer;
    }
}