// 브루트포스
class Solution {
    
    
    private static Character[][] origin = {{'.','.','.'}, {'.','.','.'},{'.','.','.'}};;
    private static Character[][] map = {{'.','.','.'}, {'.','.','.'},{'.','.','.'}};
    private static boolean flag = false;
    
    public int solution(String[] board) {
      
        for(int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if(board[i].charAt(j) == 'O') {
                    origin[i][j] = 'O';
                }
                
                if(board[i].charAt(j) == 'X') {
                    origin[i][j] = 'X';
                }
            }
        }
        
       
        ticktakto(0);
        
        int answer = flag ? 1 : 0;
        
        return answer;
    }
    
    public void ticktakto(int cnt) {
       
        if(isWinnerDecided() || cnt == 9) {
           if (isSame()) {
               flag = true;
           }         
           return; 
        }
        
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {

                if (isSame()) {
                    flag = true;
                    return;
                }

                
                if (map[i][j] != '.') {
                    continue;
                }
                
                if (cnt % 2 == 0) {
                    map[i][j] = 'O';
                    ticktakto(cnt+1);
                    map[i][j] = '.';
                }
                else {
                    map[i][j] = 'X';
                    ticktakto(cnt+1);
                    map[i][j] = '.';
                }
            }
        }
        
    }
    
    public void print(Character[][] obj) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                System.out.print(obj[i][j]);
            }
            System.out.println();
        }
    }
    
    public boolean isWinnerDecided(){
        for (int i=0;i<3;i++) {
            if (map[i][0]!='.' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                return true;
            }
            if (map[0][i]!='.' && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                return true;
            }
        }
        
        if (map[0][0] != '.' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            return true;
        }
        
         if (map[0][2] != '.' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            return true;
        }
        
        
        return false;
    }
    
    public boolean isSame() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (origin[i][j] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}