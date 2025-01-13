import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int algoMax = 0;
        int codingMax = 0;
        for (int i=0;i<problems.length;i++) {
            if (algoMax < problems[i][0]) {
                algoMax = problems[i][0];
            }
            
            if (codingMax < problems[i][1]) {
                codingMax = problems[i][1];
            }
        }
        
        if (alp > algoMax) {
            alp = algoMax;
        }
        
        if (cop > codingMax) {
            cop = codingMax;
        }
        
    
            
        int[][] dp = new int[algoMax+1][codingMax+1];

        for (int i=0;i<=algoMax;i++) {
            for (int j=0;j<=codingMax;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;

        for (int a = alp; a <= algoMax; a++) {
            for (int c = cop; c <= codingMax; c++) {

                if (a < algoMax) { //알고력 +1
                    dp[a+1][c] = Math.min(dp[a+1][c] , dp[a][c] + 1);
                }

                if (c < codingMax) { // 코딩력 +1
                    dp[a][c+1] = Math.min(dp[a][c+1], dp[a][c] + 1);
                }

                for (int i=0;i<problems.length;i++) { // 문제 하나 풀기
                    if (a < problems[i][0] || c < problems[i][1]) {
                        continue; // 풀 수 없는 문제
                    }

                    int algoMin = Math.min(algoMax, a+problems[i][2]);
                    int codingMin = Math.min(codingMax, c+problems[i][3]);

                    dp[algoMin][codingMin] = Math.min(dp[algoMin][codingMin], dp[a][c] + problems[i][4]);
                }
            }
        }

        answer = dp[algoMax][codingMax];
            
    

        return answer;
    }
}