package com.shh.mytest;

import java.io.*;
import java.util.*;

public class Test5E {

    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= 32 && c != -1);
            long sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sgn;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static final class Fenwick {
        int n;
        int[] cnt;
        long[] sum;

        Fenwick(int n) {
            this.n = n;
            cnt = new int[n + 2];
            sum = new long[n + 2];
        }

        void add(int i, int v, long val) {
            for (; i <= n; i += i & -i) {
                cnt[i] += v;
                sum[i] += val;
            }
        }

        int kth(int k) {
            int pos = 0;
            for (int bit = Integer.highestOneBit(n); bit != 0; bit >>= 1) {
                int nxt = pos + bit;
                if (nxt <= n && cnt[nxt] < k) {
                    k -= cnt[nxt];
                    pos = nxt;
                }
            }
            return pos + 1;
        }

        long prefixSum(int i) {
            long s = 0;
            for (; i > 0; i -= i & -i) s += sum[i];
            return s;
        }

        int prefixCnt(int i) {
            int s = 0;
            for (; i > 0; i -= i & -i) s += cnt[i];
            return s;
        }
    }

    static int lower(long[] a, long x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        long[] h = new long[n];

        for (int i = 0; i < n; i++) h[i] = fs.nextLong();

        long[] all = new long[2 * n];
        long[] L = new long[n];
        long[] R = new long[n];

        for (int i = 0; i < n; i++) {
            L[i] = h[i] - (i + 1);
            R[i] = h[i] + (i + 1);
            all[i] = L[i];
            all[i + n] = R[i];
        }

        Arrays.sort(all);
        int m = 1;
        for (int i = 1; i < all.length; i++)
            if (all[i] != all[i - 1]) all[m++] = all[i];

        all = Arrays.copyOf(all, m);

        Fenwick f = new Fenwick(m);

        long ans = Long.MAX_VALUE;

        int k = (n + 1) / 2;

        for (int i = 0; i < n; i++) {

            int li = lower(all, L[i]) + 1;
            int ri = lower(all, R[i]) + 1;

            f.add(li, 1, L[i]);
            f.add(ri, 1, R[i]);

            int pos = f.kth(k);

            long median = all[pos - 1];

            long leftSum = f.prefixSum(pos);
            long leftCnt = f.prefixCnt(pos);

            long totalSum = f.prefixSum(m);
            long totalCnt = f.prefixCnt(m);

            long cost =
                    median * leftCnt - leftSum +
                            (totalSum - leftSum) - median * (totalCnt - leftCnt);

            if (cost < ans) ans = cost;
        }

        System.out.println(ans);
    }
}