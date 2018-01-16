/**
 * Created by Saksham on 2016-05-22.
 */

import java.util.*;
import java.io.*;

public class Nukit {
    static BufferedReader br;
    static int[][][][][] cache;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        cache = new int[2][9][9][9][9];
        int N = rInt();
        for (int x =0; x < N;x++) {
            int[] t= rIntAr();
            System.out.println(recur(t[0],t[1],t[2],t[3], 1) == 1?"Patrick":"Roland");
        }
/*AABDD
ABCD
CCD
BBB
AD*/


    }
    static boolean comboA(int a,int b,int c,int d) {
        if (a > 1 && b > 0 && d > 1) {
            return true;
        }
        return false;
    }

    static boolean comboB(int a,int b,int c,int d) {
        if (a > 0 && b > 0 && c > 0 && d > 0) {
            return true;
        }
        return false;
    }

    static boolean comboC(int a,int b,int c,int d) {
        if (c > 1 && d > 0) {
            return true;
        }
        return false;
    }

    static boolean comboD(int a,int b,int c,int d) {
        if (b > 2) {
            return true;
        }
        return false;
    }

    static boolean comboE(int a,int b,int c,int d) {
        if (a > 0 && d > 0) {
            return true;
        }
        return false;
    }

    static int recur(int a, int b, int c, int d, int turn) {
       //System.out.println(s + " " + a + " " + b + " " + c + " " + d + " TURN: " + turn);
            if(cache[turn][a][b][c][d] != 0) return cache[turn][a][b][c][d];
        int x = turn^1;
            int opt1 = x, opt2 = x, opt3 = x, opt4 =x, opt5 = x;
            if (!comboA(a,b,c,d) && !comboB(a, b, c, d) && !comboC(a,b,c,d) && !comboD(a,b,c,d) && !comboE(a,b,c,d)){ return cache[turn][a][b][c][d] =  turn^1;}
            if (comboA(a,b,c,d)) {
                opt1 = recur(a - 2, b - 1, c, d - 2, turn^1);
              //  System.out.println("OPTION 1: " + opt1);
            }
            if (comboB(a, b, c, d)) {
                opt2 =  recur(a-1,b-1,c-1,d-1, turn^1);
             //   System.out.println("OPTION 2: " + opt2);
            }
            if (comboC(a, b, c, d)) {
                opt3 = recur(a,b,c-2,d-1, turn^1);
           //     System.out.println("OPTION 3: " + opt3);
            }
            if (comboD(a, b, c, d)) {
                opt4 = recur(a,b-3,c,d,turn^1);
             //   System.out.println("OPTION 4: " + opt4);
            }
            if (comboE(a, b, c, d)) {
                opt5 = recur(a-1,b,c,d-1,turn^1);
             //   System.out.println("OPTION 5: " + opt5);
            }
    if (turn == 1)
         return cache[turn][a][b][c][d] = opt1 | opt2 | opt3 | opt4 | opt5;
    else
        return cache[turn][a][b][c][d] = opt1 & opt2 & opt3 & opt4 & opt5;
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
