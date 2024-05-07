class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long cost = 0;
        for (int i=1;i<=count;i++) {
            cost += price * i;
        }
        
        answer = (money < cost) ? cost - money : 0;
        
        return answer;
    }
}