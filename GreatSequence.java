/**
 * Created by Saksham on 2016-04-16.
 */

import java.util.*;
import java.io.*;

public class GreatSequence {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] t= rIntAr();
        int N = t[0];
        long K = t[1];
        int M = t[2];
        int[] arr = new int[N];
        long[] cache = new long[N];
        t = rIntAr();
        cache[0] = t[0];
        HashMap<Integer, NavigableSet<Integer>> map = new HashMap<>();
        for (int x =1; x < N; x++) {
            cache[x] = t[x] + cache[x-1];
            if (!map.containsKey(t[x-1])) {
                map.put(t[x-1], new TreeSet<Integer>());
            }
            map.get(t[x-1]).add(x-1);

        }
        if (!map.containsKey(t[N-1])) {
            map.put(t[N-1], new TreeSet<Integer>());
        }
    //    cache[0] = 0;
        map.get(t[N-1]).add(N-1);
        for (int i = 0; i < M; i++) {
            int[] q = rIntAr();
            int a = q[0];
            int b = q[1];
            int X = q[2]-1;
            int Y = q[3]-1;
            //System.out.println(map.get(a).ceiling(X) + " " + map.get(b));
       //     System.out.println("TOTAL: " + cache[Y] + " " + cache[X] + " " +  ((cache[Y] - (X==0?X:cache[X-1])) ));
            //if (x != null && y != null) {
            try {
                if (((cache[Y] - (X==0?X:cache[X-1])) ) > K && map.get(a).ceiling(X) <= Y && map.get(b).ceiling(X) <= Y) {
                    System.out.println("Yes");
                } else
                    System.out.println("No");
            } catch(Exception e) {
                System.out.println("No");
            }
          //  }
        }
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
