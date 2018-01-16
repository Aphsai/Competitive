/**
 * Created by Saksham on 2016-05-17.
 */

import java.util.*;
import java.io.*;

public class ItamiAndCandy {
    static BufferedReader br;
    static boolean[] sieve(int n) {
        boolean[] temp = new boolean[n+1];
        temp[0] = true;
        temp[1] = true;
        for (int x = 2; x*x < n+1; x++) {
            if (!temp[x]) {
                for (int y = x; y*x < n+1; y++) {
                    temp[y*x] = true;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
     //   Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = Integer.parseInt(token[0]);
        int X = Integer.parseInt(token[1]);
        boolean[] isPrime = sieve(N);
        int total = 0;
        for (int x =2; x < N; x++) {
            if (!isPrime[x]) {
                int candies = N - x - 1;
               // System.out.println(x + " " + candies + " " + candies/X*2 + " " + total);
//                for (int y = 0; y * X <= candies; y++) {
//                    //   System.out.println(x + " " + y + " " + 0);
//                    if (y * X < candies) total += 2;
//                    else {
//                        total++;
//                    }
//                }
                total += (candies/X + 1)*2;
                if ((candies+1)%X == 0) total++;
            }
        }
        if (!isPrime[N]) total++;
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
