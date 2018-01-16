/**
 * Created by Saksham on 2016-09-18.
 */

import java.util.*;
import java.io.*;

public class Paradox {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int t= rInt();
        boolean fa = false;
        boolean tr = false;
        for (int x = 0; x < t; x++) {
            String[] token = read();
            if (token[0].equals("1")) {
                if (token[1].equals("true")) {
                    if (tr) System.out.println("false");
                    else System.out.println("true");
                    tr = true;
                }
                else {
                    if (fa) System.out.println("false");
                    else System.out.println("true");
                    fa = true;
                }
            }
            else if (token[0].equals("2")) {
                if (token[1].equals("true")) {
                    if (!tr) System.out.println("false");
                    else System.out.println("true");
                    tr = false;
                }
                else {
                    if (!fa) System.out.println("false");
                    else System.out.println("true");
                    fa = false;
                }

            }
            else if (token[0].equals("3")) {
                   if (token[1].equals("false")) {
                    if (fa) System.out.println(0);
                    else System.out.println(-1);
                }
                else {
                    if (tr && fa) System.out.println(1);
                    else if(tr) System.out.println(0);
                    else System.out.println(-1);
                }

            }
            else {
                if (fa) System.out.print("false");
                if (fa && true) System.out.print(" ");
                if (tr) System.out.print("true");
                System.out.println();
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
