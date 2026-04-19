package com.shh.mytest;

import java.io.*;
import java.util.*;

public class Test2B {

    static class DSU {
        int[] parent;
        int[] value;

        DSU(int n) {
            parent = new int[n];
            value = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                value[i] = -1;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);

            if (ra == rb) return true;


            if (value[ra] != -1 && value[rb] != -1 && value[ra] != value[rb]) {
                return false;
            }

            parent[rb] = ra;


            if (value[ra] == -1) {
                value[ra] = value[rb];
            }

            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        Map<String, Integer> id = new HashMap<>();
        int next = 1001;


        for (String s : a) {
            if (!Character.isDigit(s.charAt(0))) {
                id.putIfAbsent(s, next++);
            }
        }
        for (String s : b) {
            if (!Character.isDigit(s.charAt(0))) {
                id.putIfAbsent(s, next++);
            }
        }

        DSU dsu = new DSU(next);


        for (int i = 0; i <= 1000; i++) {
            dsu.value[i] = i;
        }

        boolean ok = true;

        for (int i = 0; i < n; i++) {
            int x = getId(a[i], id);
            int y = getId(b[i], id);

            if (!dsu.union(x, y)) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");
    }

    static int getId(String s, Map<String, Integer> id) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }
        return id.get(s);
    }
}