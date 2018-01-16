/**
 * Created by Saksham on 2016-09-18.
 */

import java.util.*;
import java.io.*;

public class Dodgeball {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int t= rInt();
        String[] token = read();
        char f = ' ';
        int y = 0;
        int pre = 1;
        long total = 0;
        for (int x = 2; x < t+1; x++) {
            if (token[x - 1].charAt(0) != f || x == t) {
                if (x == t) {
                    if (token[x - 1].charAt(0) == f) pre--;
                    else { total++; }
                }
              //  else if (x!=t-1 && token[x].charAt(0) != token[x+1].charAt(0))
                f = token[x-1].charAt(0);
                y = x-pre;
                pre = x;
              //  System.out.println(token[x-1] + " " + y);
                    total += (y) * (y + 1) /2;
                total %= 1000000007;
               // System.out.println(total);
            }
        }
        System.out.println(total);
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
