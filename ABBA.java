/**
 * Created by Saksham on 2016-05-31.
 */

import java.util.*;
import java.io.*;

public class ABBA {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = rInt();
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            String T = br.readLine();
            boolean found = false;
            Queue<String> q = new ArrayDeque<>();
            HashSet<String> set = new HashSet<String>();
            q.add((S));
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (!set.contains(cur)) {
                    set.add(cur);
                    // System.out.println(cur);
                    if (cur.equals(T)) {
                        found = true;
                        break;
                    }
                    if (cur.length() <= T.length()) {
                        q.add(cur + "A");
                        q.add(new StringBuilder(cur).reverse().append('B').toString());
                    }
                }
            }
            if (!found) System.out.println("NO");
            else System.out.println("YES");
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
