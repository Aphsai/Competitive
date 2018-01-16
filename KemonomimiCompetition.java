/**
 * Created by Saksham on 2016-04-12.
 */

import java.util.*;
import java.io.*;

public class KemonomimiCompetition {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int N = rInt();
        int[] cute = rIntAr();
        int[][] prob = new int[N][4];
        int start = 0;
        for (int x = 0; x < N; x++) {
            prob[x] = rIntAr();
            start = Math.max(start, prob[x][2]);
        }
        int rem = 180-start;
        for (int x = 0; x < N; x++) {
            if (prob[x][3]* cute[prob[x][0]-1] <= rem) {
                System.out.println(10-prob[x][1]);
            }
            else {
                if (prob[x][1] == 10) {
                    System.out.println(0);
                }
                else
                System.out.println("The kemonomimi are too cute!");
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
