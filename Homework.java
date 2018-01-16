/**
 * Created by Saksham on 2016-05-07.
 */

import java.util.*;
import java.io.*;

public class Homework {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
       // int lim = 100;
        int lim = 10000008;
        int isPrime[] = new int[lim];
        for (int x = 2; x < lim; x++) {
            if (isPrime[x] == 0) {
               // System.out.print(x + " " );
                for (int y = 1; y * x < lim; y++) {
               //     System.out.print(x*y + " ");
                    isPrime[y*x]++;
                }
               // System.out.println();
            }
        }
        int N = rInt();
        for (int x = 0; x < N; x++) {
            token = read();
            int a= toInt(token[0]);
            int b = toInt(token[1]);
            int c= toInt(token[2]);
            int total = 0;
            for (int y = a; y <= b; y++) {

                if (isPrime[y] == c) {
                   // System.out.println(y);
                    total++;
                }
            }
            System.out.printf("Case #%d: %d\n", (x+1), total);
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
