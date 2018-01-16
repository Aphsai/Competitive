/**
 * Created by Saksham on 2016-05-19.
 */

import java.util.*;
import java.io.*;

public class TheFasterWay {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        //String[] token = nu
        int[] t= rIntAr();
        int N = t[0];
        int R = t[1];
        int M = t[2];
        boolean[] special = new boolean[N+1];
        args = read();
        for (int x =0 ; x < R; x++) {
            special[toInt(args[x])] = true;
        }
        Stack<Integer> st = new Stack<>();
        args = read();
        int slow =0;
        int rem = 0;
        for (int x = 0; x < M; x++) {
            int cur = toInt(args[x]);
            if (!special[cur]) {
                slow++;
            }
            else {
                rem++;
            }
        }
        int fast = 0;
        int total = 0;
        if (slow > rem) {
            fast += rem;
            total = (fast*(fast+1))/2;
            total += (slow*(slow+1))/2;
        }
        else {
            rem -= slow;
            fast += slow;
            slow += rem/2;
            fast += rem/2;
            fast += rem%2==0?0:1;
            total = (fast*(fast+1))/2;
            total += (slow*(slow+1))/2;
        }
        System.out.println(total);
        //int total = slow;


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
