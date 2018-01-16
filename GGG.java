/**
 * Created by Saksham on 2016-04-02.
 */

import java.util.*;
import java.io.*;

public class GGG {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        int[] I = rIntAr();
        int M = rInt();
        int[] L = rIntAr();
        int[][] cache = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0;y  < M; y++) {
                if (I[x] == L[y]) {
                    if (x ==0 || y == 0) {cache[x][y] = 1;}
                    else {cache[x][y] = cache[x-1][y-1]+1;}
                }
                else
                    if (x > 0 && y > 0){ cache[x][y] = Math.max(cache[x-1][y], cache[x][y-1]);}
                    else if (x == 0 && y > 0) {cache[x][y] = cache[x][y-1];}
                    else if (y == 0 && x > 0) {cache[x][y] = cache[x-1][y];}
            }
        }
        System.out.println(cache[N-1][M-1]);
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
