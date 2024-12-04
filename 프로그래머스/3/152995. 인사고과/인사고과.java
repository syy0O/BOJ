import java.util.*;

class Solution {
    private class Worker implements Comparable<Worker> {
        int idx;
        int attitude;
        int peer;
        public Worker(int idx, int attitude, int peer) {
            this.idx = idx;
            this.attitude = attitude;
            this.peer = peer;
        }
        
        @Override
        public int compareTo(Worker w) {
            if (w.attitude == attitude) {
                return peer - w.peer;
            }
            
            return w.attitude - attitude;
        }
    }
    
    public int solution(int[][] scores) {
        int answer = 0;
        
        List<Worker> workers = new ArrayList<>();
        for (int i=0;i<scores.length;i++) {
            workers.add(new Worker(i,scores[i][0],scores[i][1]));
        }
        Collections.sort(workers);
        
        
        Map<Integer, Integer> workerScore = new TreeMap<>(Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        
        for (int i=0;i<workers.size();i++) {
            if (workers.get(i).peer >= max) {
                max = workers.get(i).peer;
                int sum = workers.get(i).attitude + workers.get(i).peer;
                workerScore.put(sum, workerScore.getOrDefault(sum,0)+1);
                continue;
            }
            
            if (workers.get(i).idx == 0) {
                answer = -1;
                break;
            }
        }
        
        
        if (answer != -1) {
            int target = scores[0][0] + scores[0][1];
            
            for (int score : workerScore.keySet()) {
                if (target == score) {
                    answer++;
                    break;    
                }
                
                answer += workerScore.get(score);
            }
            
            
        }

        return answer;
    }
}