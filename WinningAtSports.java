/**
 * Created by Saksham on 2016-05-08.
 */

import java.util.*;
import java.io.*;

public class WinningAtSports {
    static BufferedReader br;
    static long stressFree;
    static long stressFul;
    static int a;
    static int b;
    static long [][] cache;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        for (int i = 0; i < N; i++) {
            token = br.readLine().split("-");
            a = toInt(token[0]);
            b = toInt(token[1]);
            stressFree = 0;
            stressFul = 0;
            if (b != 0) {
                cache = new long[a + 1][b + 1];
                for (int x = 0; x < a + 1; x++) {
                    Arrays.fill(cache[x], -1);
                }
                sFree(a, b);
                for (int x = 0; x < a + 1; x++) {
                    Arrays.fill(cache[x], -1);
                }
                sFull(a, b);
            }
            else {
                stressFree = 1;
                stressFul = 1;
            }
            //System.out.println();
            System.out.printf("Case #%d: %d %d\n",(i+1), stressFree, stressFul);
        }
    }
    static long sFree(int A, int B) {
       // System.out.print(A + " " + B + " || ");
     //   System.out.print(cache[A][B]);
        stressFree = 0;
        if (cache[A][B] != -1) {
            return cache[A][B];
        }
        if (B ==0) {
            return (cache[A][B] = 1);
        }
        if (B >= A) {
            return (cache[A][B] = 0);
        }
        if (B != 0) {
            stressFree += cache[A][B-1] = sFree(A, B - 1)%1000000007;
        }
        if (A!=0) {
            stressFree += cache[A-1][B] = sFree(A - 1, B)%1000000007;
        }
        return stressFree%=1000000007;
    }
    static long sFull(int A, int B) {
        stressFul = 0;
        if (cache[A][B] != -1) {
            return cache[A][B];
        }
        if (B != b && A > B) {
            return cache[A][B] = 0;
        }
        if (B==0) {
            return cache[A][B] = 1;
        }
        if (B!= 0) {
            stressFul += cache[A][B-1] = sFull(A, B-1)%1000000007;
        }
        if (A !=0) {
            stressFul += cache[A-1][B] = sFull(A-1,B)%1000000007;
        }
        return stressFul%=1000000007;
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
