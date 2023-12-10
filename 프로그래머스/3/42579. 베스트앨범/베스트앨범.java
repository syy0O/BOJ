import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    
    private static HashMap<String, Genre> genresWithAlbums;

    private static class Genre implements Comparable<Genre>{
        int totalPlayCnt;
        ArrayList<Album> albums;

        public Genre(int totalPlayCnt) {
            this.totalPlayCnt = totalPlayCnt;
            albums = new ArrayList<>();
        }

        public void addAlbum(Album album) {
            albums.add(album);
            Collections.sort(albums);
        }

        @Override
        public int compareTo(Genre o) {
            return o.totalPlayCnt - totalPlayCnt;
        }
    }

    public static class Album implements Comparable<Album> {
        int idx;
        int plays;

        public Album(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }


        @Override
        public int compareTo(Album o) {
            if (plays == o.plays) {
                return idx - o.idx;
            }
            return o.plays - plays;
        }

    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        genresWithAlbums = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int albumPlays = plays[i];

            Genre value;
            if (!genresWithAlbums.containsKey(genre)) {
                value = new Genre(albumPlays);
                value.addAlbum(new Album(i, albumPlays));
            } else {
                value = genresWithAlbums.get(genre);
                value.totalPlayCnt += albumPlays;
                value.addAlbum(new Album(i, albumPlays));
            }

            genresWithAlbums.put(genre, value);
        }

        ArrayList<Genre> orderedGenre = new ArrayList<>();
        for (String s : genresWithAlbums.keySet()) {
            orderedGenre.add(genresWithAlbums.get(s));
        }
        Collections.sort(orderedGenre);

        ArrayList<Integer> results = new ArrayList<>();
        for (Genre genre : orderedGenre) {
            int albumCnt = genre.albums.size() > 2 ? 2 : genre.albums.size();
            for (int i = 0; i < albumCnt; i++) {
                Album album = genre.albums.get(i);
                results.add(album.idx);
            }
        }

        int[] answer = new int[results.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = results.get(i);
        }

        return answer;
    }
}