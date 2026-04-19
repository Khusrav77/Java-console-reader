package com.shh.mytest;

import java.io.*;
import java.util.*;

public class Test3C {

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = Math.abs(x);
            this.y = Math.abs(y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        // читаем точки
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            points[i] = new Point(x, y);
        }

        // сортируем по x
        Arrays.sort(points, Comparator.comparingLong(p -> p.x));

        // dp[i] = минимальная стоимость для первых i точек
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Long.MAX_VALUE;

            long maxY = 0;

            // пробуем объединять точки [j ... i-1]
            for (int j = i - 1; j >= 0; j--) {

                maxY = Math.max(maxY, points[j].y);

                // площадь прямоугольника
                long cost = 4L * points[i - 1].x * maxY;

                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        System.out.println(dp[n]);
    }
}
