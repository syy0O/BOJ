
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

class Solution {
    
     private static class Process implements Comparable<Process> {
        int idx;
        int property;

        @Override
        public int compareTo(Process o) {
            return o.property - property;
        }

        public Process (int idx, int property) {
            this.idx = idx;
            this.property = property;
        }
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<Integer> arrPriorities = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            arrPriorities.add(priorities[i]);
        }

        Collections.sort(arrPriorities, Collections.reverseOrder()); 

        Deque<Process> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(new Process(i, priorities[i])); 
        }

        int idx = 0;
        while (true) {
            if (queue.peekFirst().property == arrPriorities.get(idx)) {
                if(queue.peekFirst().idx == location) {
                    break;
                }
                queue.pollFirst();
                idx++;
                answer++;
            }
            else {
                queue.addLast(queue.pollFirst()); 
            }
        }

        return answer;
    }
}