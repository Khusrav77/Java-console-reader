package com.shh.mytest;
import java.io.*;
import java.util.*;


public class Test1A {

        static class Word implements Comparable<Word> {
            String word;
            int count;

            Word(String word, int count) {
                this.word = word;
                this.count = count;
            }

            @Override
            public int compareTo(Word other) {
                if (this.count != other.count) {
                    return Integer.compare(this.count, other.count);
                }
                return this.word.compareTo(other.word);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Word wordObj = (Word) obj;
                return count == wordObj.count && word.equals(wordObj.word);
            }

            @Override
            public int hashCode() {
                return 31 * word.hashCode() + count;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);

            String[] firstLine = br.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            // Map: первая буква -> TreeSet слов, начинающихся на эту букву
            Map<Character, TreeSet<Word>> map = new HashMap<>();
            // Счётчики использований каждого слова
            Map<String, Integer> counts = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                char firstChar = word.charAt(0);
                map.computeIfAbsent(firstChar, c -> new TreeSet<>()).add(new Word(word, 0));
                counts.put(word, 0);
            }

            for (int i = 0; i < k; i++) {
                char ch = br.readLine().charAt(0);
                TreeSet<Word> set = map.get(ch);
                // Берём слово с минимальным (count, лексикографически)
                Word best = set.first();
                String chosen = best.word;
                pw.println(chosen);

                // Обновляем счётчик использования
                int newCount = counts.get(chosen) + 1;
                counts.put(chosen, newCount);

                // Удаляем старый объект и добавляем новый с обновлённым count
                set.remove(best);
                set.add(new Word(chosen, newCount));
            }

            pw.close();
            br.close();
        }

}
