import java.util.*;

class Solution {
    
    private final int[] dr = {1,0,0,-1}; // d l r u
    private final int[] dc = {0,-1,1,0};
    private final String[] token = {"d", "l", "r", "u"};

    private String[][] path;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        path = new String[n+1][m+1]; 
        for(int i=1;i<=n;i++) {
            Arrays.fill(path[i], "");
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(x,y,0));
        

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            if (now.k == k) { // 이동거리를 모두 소진했을 때
                continue;
            }

            for (int i=0;i<4;i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if (nr < 1 || nc < 1 || nr > n || nc > m) {
                    continue;
                }

                String pre = path[now.r][now.c];
                String curr = pre.equals("") ? token[i] : pre + token[i];
                

                if (path[nr][nc].equals("")) { // 처음 방문 할 때
                    path[nr][nc] = curr;
                    queue.addLast(new Node(nr,nc,now.k+1));
                    continue;
                }
                
                if (curr.length() >= path[nr][nc].length()) {
                    
                    String currSub = curr.substring(0,path[nr][nc].length()); // 동일 크기 만큼만 비교
                    
                    if (currSub.compareTo(pre) <= 0) {
                        path[nr][nc] = curr;
                        queue.addLast(new Node(nr,nc,now.k+1));
                        continue;  
                    }

                }

            }

        }
        
        answer = path[r][c] != null && path[r][c].length() == k ? path[r][c] : "impossible"; 
        return answer;
    }

    private static class Node {
        int r, c, k;

        public Node (int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}