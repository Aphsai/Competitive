/**
 * Created by Saksham on 2016-04-02.
 */

import java.util.*;
import java.io.*;

public class CakeBalancing {
    static BufferedReader br;
    static ArrayList<Integer> left;
    static ArrayList<Integer> right;
    static int L;
    static int R;
    static int W;
    static int lW;
    static int rW;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        L = toInt(token[0]);
        R = toInt(token[1]);
        W = toInt(token[2]);
        token = read();
        left = new ArrayList<>();
        right = new ArrayList<>();
        for (int x = 0;x  < L; x++) {
            int z = toInt(token[x]);
            left.add(z);
            lW += z;
        }
        token = read();
        for (int x = 0; x < R; x++) {
            int z = toInt(token[x]);
            right.add(z);
            rW += z;
        }
        int dif = 0 ;
        int total = 0;
        Collections.sort(right);
        Collections.sort(left);


    }

//    static int recur(int l, int r,int lW,int rW, String rem, String s) {
//        System.out.println(s);
//        if (l == 0) {
//            return r;
//        }
//        if (r == 0) {
//            return l;
//        }
//        if (Math.abs(lW - left[l-1] - rW) > W) {
//            return recur(l-1,r, lW, rW,"L", s);
//        }
//        if (Math.abs(rW - right[r-1] - lW) > W) {
//            System.out.println(Math.abs(rW - right[r-1] - lW) + " " + rW + " " + right[r-1] + " " + lW);
//            return Math.min((recur(l, r - 1, lW, rW, rem, s)), (recur(l-1, r, lW, rW,rem, s))) ;
//        }
//        return Math.min(s.equals("L")?0:1 + recur(l-1,r,lW - left[l-1], rW, "","\t "+ s + " L " + left[l-1]), s.equals("R")?0:1 + recur(l,r-1,lW,rW-right[r-1],"", "\t " + s + " R " +  right[r-1]));
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

    static int rInt() throws IOException {
        return toInt(br.readLine());
    }
}
