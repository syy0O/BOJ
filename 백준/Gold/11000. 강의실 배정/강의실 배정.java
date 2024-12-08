import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Lecture {
        int start,end;
        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>(N);

        StringTokenizer st;
        for (int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        // TODO: 강의 끝나는 시간이 가장 짧은 것으로 오름차순 정렬
        Collections.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start; // 오름차순 정렬
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙 (작은 값의 우선순위가 높음)
        pq.offer(lectures.get(0).end);

        for (int i=1;i<N;i++){ // O(NlogN)
            if(pq.peek() <= lectures.get(i).start){ // 가장 빨리 끝나는 것보다 start 시간이 같거나 클 때
                pq.poll(); // O(logN)
            }
            pq.offer(lectures.get(i).end);
        }

        System.out.println(pq.size());

    }
}
