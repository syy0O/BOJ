import java.util.*;
import java.io.*;

class Node{
	int idx, val;
	
	public Node(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 영상 개수
		int Q = Integer.parseInt(st.nextToken()); // 질문
		
		ArrayList<Node>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		/* (정점, USADO)를 graph에 추가 */
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			graph[p].add(new Node(q, r));
			graph[q].add(new Node(p, r));
			
		}
				
		// 질문
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 기준이 되는 K가 k일 때 영상 v를 보고 있는 경우
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int count = 0;
			
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[N+1];
			
			visited[v] = true;
			queue.add(v);
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				List<Node> list = graph[now]; // 영상 now와 연결돼있는 영상과의 USADO 집합
				
				for(int j=0; j<list.size(); j++) {
					
					if(!visited[list.get(j).idx] && list.get(j).val >= k) {
						// 문제 조건에 맞는 경우
						count++;
						queue.add(list.get(j).idx);
						visited[list.get(j).idx] = true;
					}
				}
			}
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}
}