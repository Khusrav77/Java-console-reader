package com.shh.mytest;

import java.io.*;
import java.util.*;

public class Test4D {

    static final int BASE = 27;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = br.readLine();
        }

        Map<Long, Integer> map = new HashMap<>();

        // считаем все маски
        for (String p : patterns) {
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (p.charAt(i) != '?') pos.add(i);
            }

            int k = pos.size();

            for (int mask = 0; mask < (1 << k); mask++) {
                long hash = 0;
                int idx = 0;

                for (int i = 0; i < m; i++) {
                    int val = 26; // wildcard

                    if (idx < k && i == pos.get(idx)) {
                        if ((mask & (1 << idx)) != 0) {
                            val = p.charAt(i) - 'a';
                        }
                        idx++;
                    }

                    hash = hash * BASE + val;
                }

                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }
        }

        long total = 0;

        for (String p : patterns) {
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (p.charAt(i) != '?') pos.add(i);
            }

            int k = pos.size();

            for (int mask = 0; mask < (1 << k); mask++) {
                long hash = 0;
                int idx = 0;

                for (int i = 0; i < m; i++) {
                    int val = 26;

                    if (idx < k && i == pos.get(idx)) {
                        if ((mask & (1 << idx)) != 0) {
                            val = p.charAt(i) - 'a';
                        }
                        idx++;
                    }

                    hash = hash * BASE + val;
                }

                int cnt = map.getOrDefault(hash, 0);

                // ВОТ КЛЮЧЕВАЯ ФОРМУЛА
                if ((k - Integer.bitCount(mask)) % 2 == 0) {
                    total += cnt;
                } else {
                    total -= cnt;
                }
            }
        }

        long result = (total - n) / 2;
        System.out.println(result);
    }
}
