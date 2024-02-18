import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       Deque<Integer> queue = new ArrayDeque<>();

        int answer = 0;
        int time = 0;
        int sum = 0;

        for (int i = 0; i < truck_weights.length; i++) {

            int truck = truck_weights[i];

            while (true) {
                if (queue.isEmpty()) {
                    queue.addLast(truck);
                    time++;
                    sum += truck;
                    break;
                }

                else if (queue.size() == bridge_length) {
                    sum -= queue.pollFirst();
                }

                else {
                    if (sum + truck <= weight) {
                        queue.addLast(truck);
                        time++;
                        sum += truck;
                        break;
                    }
                    else {
                        queue.addLast(0);
                        time++;
                    }
                }
            }

        }

        answer  = time + bridge_length;


        return answer;
    }
}