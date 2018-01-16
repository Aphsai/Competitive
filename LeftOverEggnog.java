/**
 * Created by Saksham on 2016-04-02.
 */

import java.util.*;
import java.io.*;

public class LeftOverEggnog {
    static BufferedReader br;
    static int M;
    static int Va;
    static int Vb;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = rIntAr();
        Va = t[0];
        Vb = t[1];
        M = t[2];
        if (Va == Vb && Va != M || (M > Va && M > Vb)) {
            System.out.println("not possible");
        } else {
            String s1 = "";
            String s2 = "";
            String fillA = "fill A\n";
            String pourAB = "pour A B\n";
            String emptyB = "chug B";
            String fillB = "fill B\n";
            String pourBA = "pour B A\n";
            String emptyA = "chug A";
            int steps = 0;
            int step = 0;
            int a = 0;
            int b = 0;

        }
    }

//    }
//    static void recur(int a, int b, String s) {
//        if (a == M || b == M) {
//            System.out.println(s);
//            return;
//        }
//        if (b != 0)
//        recur(a, 0, s + "\nchug B");
//        if (a != 0)
//        recur (0, b, s + "\nchug A");
//        if (a != Va)
//        recur (Va, b, s + "\nfill A");
//        if (b != Vb)
//        recur (a, Vb, s + "\nfill B");
//                if (a + b > Vb) {
//                    recur(Vb - (a+b), Vb, s  + "\npour A B");
//                }
//                else
//                    recur(0, a + b, s + "\npour A B");
//        if (a + b > Va) {
//            recur (Va, Va - (a+b), s + "\npour B A");
//        }
//            recur(a+b, 0, s + "\npour B A");
//    }
    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }

    static String[] read() throws IOException {
        return split(br.readLine());
    }
    static int[] rIntAr() throws IOException {
        String[] temp = read();
        int[] t = new int[temp.length];
        for (int x = 0; x < temp.length; x++) {
            t[x] = toInt(temp[x]);
        }
        return t;
    }
    static int rInt() throws IOException {
        return toInt(br.readLine());
    }
}
