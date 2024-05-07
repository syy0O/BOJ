// 완전탐색

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for (int i=0;i<number.length;i++) {
            int currSum = number[i];
            for (int j = i+1; j < number.length; j++) {
                currSum += number[j];
                for (int k=j+1;k<number.length;k++) {
                     currSum += number[k];  
                    if (currSum == 0) {
                        answer++;
                    }
                    currSum -= number[k];  
                }
                 currSum -= number[j];
            }
        }
        return answer;
    }
}