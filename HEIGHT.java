/**
 * Created by Saksham on 2016-05-31.
 */

import java.util.*;
import java.io.*;

public class HEIGHT {
    static BufferedReader br;
    static int N;
    static int [][] cache;
    static int [] data;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        N = rInt();
        data = new int[N];

        int max = 0;
        for (int x =0 ; x < N; x++) {
            data[x] = rInt();
            max = Math.max(max, data[x]);
        }
        cache = new int[N+2][max + 2];
        System.out.println(recur(N, max + 1));
    }
    static int recur(int n, int max) {
        if (cache[n][max] != 0) return cache[n][max];
        if (n == 0)
            return 0;
        if (data[n-1] >= max)
            return cache[n][max] = recur(n-1, max);
        return cache[n][max] = Math.max(data[n-1] + recur(n-1, data[n-1]), recur(n-1, max));
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }

    static String[] read() throws IOException {
        return split(br.readLine());
    }

    static int rInt() throws IOException {
        return toInt(br.readLine());
    }

    static int[] rIntAr() throws IOException {
        String[] temp = read();
        int[] t = new int[temp.length];
        for (int x = 0; x < temp.length; x++) {
            t[x] = toInt(temp[x]);
        }
        return t;
    }
}
