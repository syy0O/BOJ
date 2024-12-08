import java.util.*;

class Solution {
    
    private int[] discountArr;
    private int[][] usersRef;
    private int[] emoticonsRef;
    
    private int joinCnt = 0;
    private int priceSum = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        usersRef = users;
        emoticonsRef = emoticons;
        
        int m = emoticons.length;
        discountArr = new int[m];
        find(m,0);

        int[] answer = {joinCnt, priceSum};
        
        return answer;
    }
    
    public void find(int m, int idx){
        if (m == idx) {
            check();
            return;
        }
        
        for(int i = 10; i <= 40; i += 10){
            discountArr[idx] = i;
            find(m, idx + 1);
        }
    }
    
    public void check(){
        
        int cnt = 0; //가입한 유저
        int sum = 0; // 총 금액
        
        for (int u=0;u<usersRef.length;u++) { // 유저
            int userSum = 0;
            for (int i=0;i<discountArr.length;i++) { // 이모티콘 가격 할인율
                if (usersRef[u][0] > discountArr[i]) {
                    continue;
                }

                userSum += emoticonsRef[i] * (100 - discountArr[i]) / 100;
            }
            
            if (userSum < usersRef[u][1]) {
                sum += userSum;
            }
            else {
                cnt++;
            }
        }
        
        if (joinCnt < cnt) {
            joinCnt = cnt;
            priceSum = sum;
        }
        
        if (joinCnt == cnt) {
            priceSum = Math.max(priceSum,sum);
        }
        
    }
}