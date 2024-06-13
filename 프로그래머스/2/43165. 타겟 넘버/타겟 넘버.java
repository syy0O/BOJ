class Solution {
    
    private static boolean visited[][];
    private static int answer;
    private int[] copy;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length][2];
        copy = numbers.clone();
        dfs(0,0,target,0);
        return answer;
    }
    
    public void dfs(int cnt,int sum, int target, int idx) {
        if (cnt == copy.length) {    
            if (sum == target) {
                answer++;
            }
            return;
        }
        

        if (!visited[idx][0]) {
            visited[idx][0] = true;
            dfs(cnt+1, sum + copy[idx], target, idx+1);
            visited[idx][0] = false;
        }

        if (!visited[idx][1]) {
            visited[idx][1] = true;
            dfs(cnt+1,sum + -1 * copy[idx], target, idx+1);
            visited[idx][1] = false;
        }

    }

}