import java.util.*;

class Solution {
    
    private class Genre implements Comparable<Genre>{
        String genre;
        int totalCnt;
        
        public Genre(String genre, int totalCnt) {
            this.genre = genre;
            this.totalCnt = totalCnt;
        }
        
         public int compareTo(Genre g) {
            return g.totalCnt - totalCnt;
        }
    }
    
    private class Elbum implements Comparable<Elbum> {
        int idx;
        int playCnt;
        
        public Elbum(int idx, int playCnt) {
            this.idx = idx;
            this.playCnt = playCnt;
        }
        
        public int compareTo(Elbum e) {
            if (playCnt == e.playCnt) {
                return idx - e.idx;
            }
            return e.playCnt - playCnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, ArrayList<Elbum>> bestElbum = new HashMap<>();
        for (int i=0;i<genres.length;i++) {
            
            Elbum elbum = new Elbum(i,plays[i]);
            ArrayList<Elbum> elbums = new ArrayList<>();  
            
            if (bestElbum.containsKey(genres[i])) {
               elbums = bestElbum.get(genres[i]);
            }
            
            elbums.add(elbum);
            bestElbum.put(genres[i], elbums);
        }
            
        
        PriorityQueue<Genre> genreWithPlayCnt = new PriorityQueue<>();
        for (String key : bestElbum.keySet()) {
            
            ArrayList<Elbum> elbums = bestElbum.get(key);
            Collections.sort(elbums);
            
            int total = 0;
            for (Elbum elbum : elbums) {
                total += elbum.playCnt;
            }
            genreWithPlayCnt.add(new Genre(key, total));
        }
        
       
        ArrayList<Integer> answers = new ArrayList<>();
        while(!genreWithPlayCnt.isEmpty()) {
            Genre curr = genreWithPlayCnt.poll();
            ArrayList<Elbum> elbums = bestElbum.get(curr.genre);
            int elbumSize = elbums.size() >= 2 ? 2 : elbums.size();
            
            for (int i=0;i<elbumSize;i++) {
                answers.add(elbums.get(i).idx);
            }
        }
        
        int[] answer = answers.stream()
			.mapToInt(i -> i)
            .toArray();
        
        return answer;
    }
}