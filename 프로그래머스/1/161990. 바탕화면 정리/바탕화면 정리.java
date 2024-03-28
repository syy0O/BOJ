class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int r=0; r<wallpaper.length; r++) {
            String curr = wallpaper[r];    
            for (int c=0;c<curr.length();c++) {
                if (curr.charAt(c) == '#') {
                    if (minX > r) {
                        minX = r;
                    }
                    
                    if (minY > c) {
                        minY = c;
                    }
                    
                    if (maxX < r+1) {
                        maxX = r+1;
                    }
                    
                    if (maxY < c+1) {
                        maxY = c+1;
                    }
                }
            }
        }
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        
        
        return answer;
    }
    
}