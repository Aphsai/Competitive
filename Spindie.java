/**
 * Created by Saksham on 2016-04-09.
 */

import java.util.*;
import java.io.*;

public class Spindie {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 0; test < 10; test++) {
            int N = rInt();
            String[] t= read();
            HashSet<Integer> set = new HashSet<>();
            for (int x = 0; x < N; x++){
                set.add(toInt(t[x]));
            }
            HashSet<Integer> contains = new HashSet<>();
            for (int i: set) {
                for (int x: set) {
                    for (int z: set) {
                  ///      System.out.print((i * x + z) + " " + (i+x+z) + " " + (i*x*z) + " " + (i+x*z));
                        contains.add(i*x+z);
                        contains.add(i+x+z);
                        contains.add(i*x*z);
                        contains.add((i+x)*z);
                    }
                }
            }
            int[] te = rIntAr();
            for (int x = 0; x < 5; x++) {
                if (contains.contains(te[x])) {
                    System.out.print("T");
                }
                else
                    System.out.print("F");
            }
            System.out.println();
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
