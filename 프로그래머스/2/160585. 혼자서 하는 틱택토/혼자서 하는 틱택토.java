// 백트래킹
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
       
        if(isWinnerDecided() || cnt == 9) { // 장기말을 다 두었거나, 승자가 정해졌을 때
           if (isSame()) {
               flag = true;
           }         
           return; 
        }
        
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                
                if (isSame()) { // origin 배열과, 현재 배열이 같아질 때
                    flag = true;
                    return;
                }

                
                if (map[i][j] != '.') { // 이미 말이 놓아져 있을 때
                    continue;
                }
                
                map[i][j] = cnt % 2 == 0 ? 'O' : 'X';
                ticktakto(cnt+1);
                map[i][j] = '.';
            }
        }
        
    }
    
    
    public boolean isWinnerDecided(){
        for (int i=0;i<3;i++) {
            if (map[i][0]!='.' && map[i][0] == map[i][1] && map[i][1] == map[i][2]) { // 가로
                return true;
            }
            if (map[0][i]!='.' && map[0][i] == map[1][i] && map[1][i] == map[2][i]) { // 세로
                return true;
            }
        }
        
        if (map[0][0] != '.' && map[0][0] == map[1][1] && map[1][1] == map[2][2]) { // 우하향 대각선
            return true;
        }
        
         if (map[0][2] != '.' && map[0][2] == map[1][1] && map[1][1] == map[2][0]) { // 우상향 대각선
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