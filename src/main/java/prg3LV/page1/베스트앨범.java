package prg3LV.page1;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, ArrayList<Song>> genrePlay = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0)+plays[i]);

            if (!genrePlay.containsKey(genres[i])) {
                genrePlay.put(genres[i], new ArrayList<>());
            }
            genrePlay.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<Integer> answer = new ArrayList<>();

        genreCount.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .forEach((entry) -> {
                    ArrayList<Song> songs = genrePlay.get(entry.getKey());
                    List<Song> collect = songs.stream().sorted().collect(Collectors.toList());

                    int index = 0;
                    for (int i = 0; i < collect.size(); i++) {
                        if (index == 2) break;
                        answer.add(collect.get(i).id);
                        index++;
                    }
                });
        // 위 stream과 동일
//        List<Map.Entry<String, Integer>> entries = new LinkedList<>(genreCount.entrySet());
//        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
//
//        List<Integer> answer = new ArrayList<>();
//
//        for (Map.Entry<String, Integer> entry : entries) {
//            ArrayList<Song> songs = genrePlay.get(entry.getKey());
//            List<Song> collect = songs.stream().sorted().collect(Collectors.toList());
//
//            int index = 0;
//            for (int i = 0; i < collect.size(); i++) {
//                if (index == 2) break;
//                answer.add(collect.get(i).id);
//                index++;
//            }
//        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    static class Song implements Comparable<Song>{
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o1) {
            if (this.play == o1.play) return this.id - o1.id;
            return o1.play - this.play;
//            if (this.play > o1.play) {
//                return -1;
//            } else if (this.play < o1.play) {
//                return 1;
//            } else {
//                if (this.id < o1.id) {
//                    return -1;
//                } else if (this.id > o1.id) {
//                    return 1;
//                }
//            }
//            return 0;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "id=" + id +
                    ", play=" + play +
                    '}';
        }
    }
}
