class Solution {
    
   
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        
        int[][] records = new int[n+1][n+1];
        for (int i=0;i<results.length;i++) {
            records[results[i][0]][results[i][1]] = 1;
            records[results[i][1]][results[i][0]] = -1;
        }
        
        
        
        for(int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if(records[i][j] == 1) { // 나는 니가 이긴걸 다 이겨
                    for (int k=1;k<=n;k++) {
                        if (records[j][k] == 1) {
                            records[i][k] = 1;
                            records[k][i] = -1;  
                        }
                    }
                }

                if (records[i][j] == -1) { // 나는 니가 진걸 다 져
                    for (int k=1;k<=n;k++) {
                        if (records[j][k] == -1) {
                             records[i][k] = -1;
                             records[k][i] = 1;   
                        }  
                    }
                }   

            }
        }
        
        
        for (int i=1;i<=n;i++) {
           for (int j=1;j<=n;j++) {
                System.out.print(records[i][j]+" ");
            }  
            System.out.println();
        }
        
        
        
        for (int i=1;i<=n;i++) {
            boolean flag = true;
            for (int j=1;j<=n;j++) {
                if ( i!= j && records[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer++;
            }  
        }
        
        return answer;
    }
    
    
    
    
    
}