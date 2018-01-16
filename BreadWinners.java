/**
 * Created by Saksham on 2016-05-03.
 */

import java.util.*;
import java.io.*;

public class BreadWinners {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        int[] t = rIntAr();
        boolean[] isPrime = new boolean[10001];
        for (int x = 2; x * x < 10001; x++) {
            if (isPrime[x] == false) {
                for (int y = x; y * x < 10001; y++) {
                    isPrime[y * x] = true;
                }
            }
        }
        for (int x = 0; x < N; x++) {
            if (t[x] <= 2) {
                System.out.println("no can do");
            }
            else {
                for (int y = t[x]-1; y > 0; y--) {
                    if (!isPrime[y]) {System.out.println(y); break;}
                }
            }
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
