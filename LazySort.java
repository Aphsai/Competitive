/**
 * Created by Saksham on 2016-05-07.
 */

import java.util.*;
import java.io.*;

public class LazySort {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        for (int i = 0; i < N; i++) {
            int T = rInt();
            token = read();
            ArrayDeque<Integer> q = new ArrayDeque<>();
            ArrayDeque<Integer> qe = new ArrayDeque<>();
            for (int x = 0; x< T; x++) {
                q.add(toInt(token[x]));
                qe.add(toInt(token[x]));
            }
            boolean sorted = Q(q, q.pollFirst());
            if (!sorted) sorted = Q(qe, qe.pollLast());
            if (!sorted) System.out.printf("Case #%d: %s\n", (i+1), "no");
            else System.out.printf("Case #%d: %s\n", (i+1), "yes");
        }

    }
    static boolean Q(ArrayDeque<Integer> q, int ind) {
        int lP = ind;
        int rP = ind;
        while (!q.isEmpty()) {
            int tLP = q.peekFirst();
            int tRP = q.peekLast();
          //   System.out.println(tLP + " " + tRP + " " + rP + " " + lP);
            boolean rem = false;
            if (tLP +1 == lP) {
                q.pollFirst();
                rem = true;
                lP--;
            }
            else if (!q.isEmpty() && tLP -1 == rP) {
                q.pollFirst();
                rem = true;
                rP++;
            }
            if (!q.isEmpty() && tRP +1 == lP) {
                q.pollLast();
                rem = true;
                lP--;
            }
            else if (!q.isEmpty() && tRP -1 == rP) {
                q.pollLast();
                rem = true;
                rP++;
            }
            if (!rem) break;
        }
        if (!q.isEmpty()) return false;
        return true;
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
