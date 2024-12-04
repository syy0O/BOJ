import java.util.*;

class Solution {
    
    private class Box implements Comparable<Box>{
        
        int dist;
        int cnt;
        
        public Box(int dist, int cnt) {
            this.dist = dist;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Box b) {
            return b.dist - dist;      
        }
    }
    
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        PriorityQueue<Box> dealiveryBox = new PriorityQueue<>();
        PriorityQueue<Box> pickupBox = new PriorityQueue<>();
            
        for (int i=0;i<n;i++) {
            if (deliveries[i] != 0) {
                dealiveryBox.add(new Box(i+1, deliveries[i]));
            }
            
            if (pickups[i] != 0) {
                pickupBox.add(new Box(i+1, pickups[i]));
            }
        }
        
        
        while (!dealiveryBox.isEmpty() ||  !pickupBox.isEmpty()) { //O(N)
            
            int target = 0;
            
            if (!dealiveryBox.isEmpty() && !pickupBox.isEmpty()) {
                target =  Math.max(dealiveryBox.peek().dist, pickupBox.peek().dist);
            }
            
            if (dealiveryBox.isEmpty()) {
                target = pickupBox.peek().dist;
            }
            
            if (pickupBox.isEmpty()) {
                target = dealiveryBox.peek().dist;
            }
            
            
            answer += target * 2;

            int remain = cap;
            
            while(!dealiveryBox.isEmpty() && remain != 0) { // O(1) => MAX 50번
                int complete = Math.min(dealiveryBox.peek().cnt, remain);
                dealiveryBox.peek().cnt -= complete;
                remain -= complete;
                
                if (dealiveryBox.peek().cnt == 0) {
                    dealiveryBox.poll();
                }
            }
            
            remain = cap;
             while(!pickupBox.isEmpty() && remain != 0) { // O(1) => MAX 50번
                int complete = Math.min(pickupBox.peek().cnt, remain);
                pickupBox.peek().cnt -= complete;
                remain -= complete;
                
                if (pickupBox.peek().cnt == 0) {
                    pickupBox.poll();
                }
            }
        }
        
        
        return answer;
    }
}