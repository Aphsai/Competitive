/**
 * Created by Saksham on 2017-01-17.
 */

import java.util.*;
import java.io.*;

public class D {
    static BufferedReader br;
    static int N;
    static int R;
    static boolean[] arr;
    static ArrayList<Integer>[] map;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
      //  Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = rIntAr();
        N = t[0];
        R = t[1];
        arr = new boolean[N+1];
        vis = new boolean[N+1];
        vis[R] = true;
        map = new ArrayList[N+1];
        arr[R] = true;
        for (int x = 1; x < N+1; x++) {
            map[x] = new ArrayList<Integer>();
        }
        for (int x = 1; x < N+1; x++) {
            t = rIntAr();
            for (int y = 1; y < t[0] + 1; y++) {
                map[x].add(t[y]);
            }
        }
        int A = 0;
        int B = 0;
        recur(R, true);
        for (int x = 1; x < N+1; x++) {
       //     System.out.println(arr[x]);
            if (vis[x] == false) {
                for (int y: map[x]){
                    if (vis[y]) {
                        arr[x] = !arr[y];
                        if (arr[x])
                            A++;
                        else
                            B++;
                        break;
                    }
                }
            }

        }
        System.out.println(B + " " + A);


    }
    static void recur(int cur, boolean team) {
     //   System.out.println(cur);
        for (int x: map[cur]) {
            if (!vis[x]) {
                vis[x] = true;
                arr[x] = !team;
                recur(x, !team);
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
