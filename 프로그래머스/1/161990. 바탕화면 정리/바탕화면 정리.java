class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minR,minC,maxR,maxC;
        
        minR = minC = 51;
        maxR = maxC = -1;
        
        
        for (int r=0; r<wallpaper.length; r++) {
            String curr = wallpaper[r];    
            for (int c=0;c<curr.length();c++) {
                if (curr.charAt(c) == '#') {
                    minR = Math.min(minR,r);
                    minC = Math.min(minC,c);
                    maxR = Math.max(maxR,r+1);
                    maxC = Math.max(maxC,c+1);
                }
            }
        }
        
        answer[0] = minR;
        answer[1] = minC;
        answer[2] = maxR;
        answer[3] = maxC;
        
        
        return answer;
    }
    
}