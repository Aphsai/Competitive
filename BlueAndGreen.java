/**
 * Created by Saksham on 2016-05-09.
 */

import java.util.*;
import java.io.*;

public class BlueAndGreen {
    static BufferedReader br;
    static int shift;
    static int S;
    static int L;
    static int R;
    static int I;
    static int M;
    static int N;
    static int MASK;
    static int[] set;
    static int total;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        N = toInt(token[0]);
        M = toInt(token[1]);
        token = read();
        S = toInt(token[0]);
        L = toInt(token[1]);
        R = toInt(token[2]);
        I = toInt(token[3]);
        set = new int[1048577];
        Arrays.fill(set, -1);
        String s = br.readLine();
        for (int x = 0; x < N; x++) {
            shift <<= 1;
            if (s.charAt(s.length() -1 - x) == 'B') shift |= 1;
        }
        MASK = (1 << N) -1;
        recur(M, shift);
        System.out.println(total);
    }
    public static void recur(int M, int shift) {
        //  System.out.println(Integer.toBinaryString(shift));
        if (set[shift] >=  M) return;
        if (set[shift] == -1) total++;
        set[shift] = M;
        if (M >= S) {
            for (int x =0; x < N; x++) {
                recur(M-S, shift^(1 << x));
            }
        }
        if (M >= L) {
            int MSB = (shift >> N-1) & 1;
            int SHIFT = (shift << 1) & MASK;
            //   System.out.println((MASK|MSB) + " " + shift);
            recur(M-L, (SHIFT | MSB));
        }   if (M >= R ) {
            int LSB = shift & 1;
            recur(M - R, (shift >> 1) | LSB << (N-1));
        }


        if (M >= I) {
            recur(M-I, ~shift & (MASK));
        }
    }

    //static int recur(BitSet set, )

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