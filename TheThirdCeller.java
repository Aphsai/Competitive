/**
 * Created by Saksham on 2016-05-01.
 */

import java.util.*;
import java.io.*;

public class TheThirdCeller {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = rInt();
        boolean[] isPrime = new boolean[1000000];
        isPrime[1] = true;
        isPrime[0] = true;
        for (int x = 2; x * x < isPrime.length; x++) {
            if (isPrime[x] == false) {
                for (int y = x; x * y < isPrime.length; y++) {
                    isPrime[x *y] = true;
                }
            }
        }
        for (int x = 0; x < N; x++) {
            int[] t= rIntAr();
            int primes = 0;
            for (int y = t[0]; y < t[1]; y++) {
                if (!isPrime[y]) primes++;
            }
            System.out.println(primes);
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
