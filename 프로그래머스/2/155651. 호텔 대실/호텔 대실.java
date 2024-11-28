import java.util.*;

class Solution {
    
    private class Reservation implements Comparable<Reservation>{
        int start;
        int end;
        
        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Reservation r) {
            return end - r.end;
        }
    }
    
    
    public int solution(String[][] book_time) {
       
        //시작 시간 기준 정렬
        Arrays.sort(book_time, (o1,o2) -> (timeToInteger(o1[0]) - timeToInteger(o2[0])));
        
        // Priority Queue 사용 -> 끝나는 시간이 짧은 순서대로 정렬
        PriorityQueue<Reservation> pq = new PriorityQueue<>();
        for (int i=0;i<book_time.length;i++) {
            String[] curr = book_time[i];
            
            int start = timeToInteger(curr[0]);
            int end = timeToInteger(curr[1]) + 10;
            Reservation now = new Reservation(start,end);
            
            //처음이거나, 가장 빨리 끝나는 청소가 지금 내 시작 시간 보다 느리다면
            if (pq.isEmpty() || pq.peek().end > start) {
                pq.add(now);
                continue;
            }
            
            // 빠르다면, 가장 빨리 청소가 끝나는 객실을 지금 예약으로 채움
            pq.poll();
            pq.add(now);
        }
                  
        // 마지막, priority queue의 크기가 정답
        int answer = pq.size();
        
        return answer;
    }
    
    public int timeToInteger(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hours = Integer.parseInt(st.nextToken()) * 60;
        int minutes = Integer.parseInt(st.nextToken());
        
        return hours + minutes;
    }
}