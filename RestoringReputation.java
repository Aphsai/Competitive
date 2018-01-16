/**
 * Created by Saksham on 2016-04-02.
 */

import java.util.*;
import java.io.*;

public class RestoringReputation {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int[] temp = rIntAr();
        int D = temp[0];
        int I = temp[1];
        int R = temp[2];
        token = read();
        char[] init = token[0].toCharArray();
        char[] fin = token[1].toCharArray();
        int[][] cache = new int[init.length+1][fin.length+1];
        for (int x = 0;x  < init.length+1; x++) {
            for (int y = 0; y < fin.length+1; y++) {
                if (x == 0) cache[x][y] = I*y;
                else if (y == 0) cache[x][y] = D*x;
                else if (init[x-1] == fin[y-1]) cache[x][y] = cache[x-1][y-1];
                else cache[x][y] = Math.min(Math.min(cache[x-1][y] + D, cache[x][y-1] + I), cache[x-1][y-1] + R);
            }
        }
        System.out.println(cache[init.length][fin.length]);
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
