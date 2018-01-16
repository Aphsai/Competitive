/**
 * Created by Saksham on 2016-05-13.
 */

import java.util.*;
import java.io.*;

public class Bananas {
    static BufferedReader br;
static boolean monkWord;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        while (true) {
            //System.out.println(br.readLine());
            char[] str = br.readLine().toCharArray();
            if (str[0] == 'X') break;
            if (str.length == 1 && str[0] == 'A') System.out.println("YES");
            else {
                monkWord = (str[0] == 'A') ? true : false;
                System.out.println(recur(str, 0, str.length) ? "YES" : "NO");
            }

        }
    }
    static char [] news;
    public static boolean recur(char[] str, int lp, int rp) {
        try {
            for (int y = 0; y < str.length; y++)   {
                lp = 0;
               news = new char[str.length];
                for (int x = 0; x < str.length; x++) {
                   // System.out.print(str[x]);
                    if (x < str.length -2 && str[x] == 'B') {
                        if (str[x + 1] == 'A' && str[x + 2] == 'S') {
                            news[lp] = 'A';
                            x += 2;
                            lp++;
                        }
                        else {
                            news[lp] = str[x];
                            lp++;
                        }
                    } else if (x < str.length - 2 && str[x] == 'A') {
                       // System.out.print(" " + str[x+1] + " " + str[x+2] + " ");
                        if (str[x + 1] == 'N' && str[x + 2] == 'A') {
                            news[lp] = 'A';
                            x+=2;
                            lp++;
                        }
                        else {
                            news[lp] = str[x];
                            lp++;
                        }
                    } else {
                        news[lp] = str[x];
                        lp++;
                    }
                }
               // System.out.println();
                System.arraycopy(news, 0, str, 0, news.length);
            }
        } catch (ArrayIndexOutOfBoundsException e) {e.printStackTrace(); return false;}
        return news[0] == 'A' && news[1] == '\u0000';
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

