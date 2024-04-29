import java.util.*;

//TODO: 소요시간이 가장 작은 애들 별로 넣어줘야함
// 1) 이차원 배열 jobs를 요청시간이 빠른 순서로 정렬한다
// 2) endTime을 정해두고, 해당 endTime 내에 들어온 요청들을 큐에 넣어준다.
// 3) 만약, 큐가 비었다면? -> endTime 보다 요청시간이 느린것을 의미 -> endTime 업데이트
// 4) 들어온 작업들에 대해 수행시간이 가장 짧은 것을 더해줌 + endTime update





class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs,(o1,o2) -> o1[0] - o2[0]); // 도착 시간 오름차 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]); // 수행시간 오름차 정렬
        
        int cnt = 0;
        int end = 0;
        int idx = 0;
        int sum = 0;
        
        while (cnt < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][0] <= end) { // 우선순위 큐 채우기
                pq.add(jobs[idx]);
                idx++;
            } 
            
            if (pq.isEmpty()) {
                end = jobs[idx][0];
            }
            else {
                int[] curr = pq.poll();
                sum += end-curr[0] + curr[1];
                end += curr[1];
                cnt++;
            }
 
        }
        
        answer = sum / cnt;
        

         return answer;
    }
    
 
}