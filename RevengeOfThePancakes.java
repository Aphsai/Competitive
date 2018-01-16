/**
 * Created by Saksham on 2016-04-09.
 */

import java.util.*;
import java.io.*;

public class RevengeOfThePancakes {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new FileReader("B-large.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("out.out"));
        int N = rInt();
        for (int x = 1; x  < N + 1; x++) {
            char[] ar = br.readLine().toCharArray();
            int flips = 0;
            loop: for (int y = 0; y < ar.length; y++) {
                if (y == 0) {
                    if (ar[y] == '-') {
                        flips++;
                    }
                    continue loop;
                }
                else {
                    if(ar[y] == '-' && ar[y-1] == '+') {
                        flips += 2;
                    }
                }
            }
            pw.println("Case #" + x +": " +  flips);
        }
        pw.close();
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
