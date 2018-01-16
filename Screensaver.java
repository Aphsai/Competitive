/**
 * Created by Saksham on 2016-09-18.
 */

import java.util.*;
import java.io.*;

public class Screensaver {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = rIntAr();
        int N = t[0];
        int M = t[1];
        char[][] map = new char[t[1]][t[0]];
        int ticks = t[2];
        int current = 0;
        int xpos = 0;
        int ypos = 0;
        for (int x = 0; x < t[1]; x++) {
            String str = br.readLine();
            for (int y =0; y < N; y++) {
                map[x][y] = str.charAt(y);
                if(map[x][y] == 'O') {xpos = x; ypos = y; map[x][y] ='.';}

            }
        }
        boolean f = true;
        boolean b = false;
        boolean u = false;
        boolean d = false;
        int x =0;
        for (x =1 ; x < ticks+1; x++) {
           // System.out.println(xpos + " " + ypos + " " + map[ypos][xpos]);
           // System.out.println(f + " " + b + " " + d + " " + u);
            if (f) {
                if (xpos + 1 >= N) {
                    break;
                }
                else if (map[ypos][xpos+1] == '|') {
                    //x++;
                    map[ypos][xpos+1] = '-';
                    b = true;
                    f = false;
                }
                else if (map[ypos][xpos+1] == '\\') {
                    x++;
                    ypos+=1;
                    xpos+=1;
                    d = true;
                    f = false;
                }
                else if (map[ypos][xpos+1] == '/') {
                    x++;
                    ypos-=1;
                    xpos+=1;
                    u = true;
                    f = false;
                }
                else if  (map[ypos][xpos+1] == '-') {
                    xpos+=2;
                }
                else {
                    xpos++;
                }
            }
            else if (b) {
                if (xpos - 1 <= -1) {
                    break;
                }
                else if (map[ypos][xpos-1] == '|') {
                //    x++;
                    map[ypos][xpos-1] = '-';
                    b = false;
                    f = true;
                }
                else if (map[ypos][xpos-1] == '\\') {
                    x++;
                    ypos-=1;
                    xpos-=1;
                    u = true;
                    b = false;
                }
                else if (map[ypos][xpos-1] == '/') {
                    x++;
                    ypos+=1;
                    xpos-=1;
                    d = true;
                    b = false;
                }
                else if  (map[ypos][xpos-1] == '-') {
                    xpos-=2;
                }
                else {
                    xpos--;
                }

            }
            else if (d) {
                if (ypos + 1 >= M) {
                    break;
                }
                else if (map[ypos+1][xpos] == '-') {
                //    x++;
                    map[ypos+1][xpos] = '|';
                    u = true;
                    d = false;
                }
                else if (map[ypos+1][xpos] == '\\') {
                    x++;
                    ypos+=1;
                    xpos+=1;
                    f = true;
                    d = false;
                }
                else if (map[ypos+1][xpos] == '/') {
                    x++;
                    ypos+=1;
                    xpos-=1;
                    b = true;
                    d = false;
                }
                else if  (map[ypos+1][xpos] == '|') {
                    ypos+=2;
                }
                else {
                    ypos++;
                }
            }
            else {
                if (ypos - 1 <= -1) {
                    break;
                }
                else if (map[ypos-1][xpos] == '-') {
                 //   x++;
                    map[ypos-1][xpos] = '|';
                    d = true;
                    u = false;
                }
                else if (map[ypos-1][xpos] == '\\') {
                    x++;
                    ypos-=1;
                    xpos-=1;
                    b = true;
                    u = false;
                }
                else if (map[ypos-1][xpos] == '/') {
                    x++;
                    ypos-=1;
                    xpos+=1;
                    f = true;
                    d = false;
                }
                else if  (map[ypos-1][xpos] == '|') {
                    ypos-=2;
                }
                else ypos--;
            }
            if (xpos < 0 || xpos >= N || ypos < 0 || ypos >= M) {System.out.println("The observer leaves the grid after " + x +" tick(s)."); return;}
        }
        if (x == ticks) System.out.println("The observer stays within the grid.");
        else System.out.println("The observer leaves the grid after " + (x+1) +" tick(s).");
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
