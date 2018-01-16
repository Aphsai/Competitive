/**
 * Created by Saksham on 2016-05-27.
 */

import java.util.*;
import java.io.*;

public class BitTesting {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int shift = 0;
        for (int x =0 ; x < 4; x++) {
            shift <<= 1;
            shift |= 1;
        }
        shift >>= 3;
        HashSet<String> set = new HashSet<>();
        System.out.println(shift);
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
