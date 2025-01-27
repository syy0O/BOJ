import java.util.*;

class Solution {
    
    private class Coordinate {
        long x;
        long y;

        Coordinate(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    
    public String[] solution(int[][] line) {
        
        List<Coordinate> cList = new ArrayList<>();
       
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i + 1; j < line.length; j++){

                long a = line[i][0], b = line[i][1], e = line[i][2],
                     c = line[j][0], d = line[j][1], f = line[j][2];
                
                if((a * d - b * c) != 0){ // 직선이 평행하지 않음
                    double x = (double) (b * f - e * d) / (a * d - b * c);
                    double y = (double) (e * c - a * f) / (a * d - b * c);
                    if(x % 1 == 0 && y % 1 == 0){                           //정수인 경우에만 저장
                        cList.add(new Coordinate((long)x, (long)y));   
                    }
                }
            }
        }
        
        //교점의 최소, 최대값 찾기
        Coordinate min = new Coordinate(Long.MAX_VALUE, Long.MAX_VALUE);
        Coordinate max = new Coordinate(Long.MIN_VALUE, Long.MIN_VALUE);
        
        for(Coordinate c : cList){
            long cx = c.x, cy = c.y;
            
            if(cx < min.x){
                min.x = cx;
            }
            
            if(cy < min.y){
                min.y = cy;
            }
            
            if(cx > max.x){
                max.x = cx;
            }
            
            if(cy > max.y){
                max.y = cy;
            }
        }
        
        
        int width = (int)(max.x - min.x + 1);
        int height = (int)(max.y - min.y + 1);
            
        char[][] arr = new char[height][width];
        
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                arr[i][j] = '.';
            }           
        }
        
       
        for(Coordinate c : cList){ // 상대좌표
            arr[(int)(max.y - c.y)][(int)(c.x - min.x)] = '*';
        }
        
      
        String[] answer = new String[height];
        for(int i = 0; i < answer.length; i++){
            answer[i] = new String(arr[i]);
        }
        
        return answer;
    }
}