/**
 * Created by Saksham on 2016-04-09.
 */

import java.util.*;
import java.io.*;

public class GlobalWarming {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int[] t = rIntAr();
            if (t.length == 1 && t[0] == 0) {
                break;
            } else {
                if (t.length != 0) {
                    for (int x = 0; x < t.length - 1; x++) {
                        t[x] = t[x + 1] - t[x];
                        //   System.out.print(t[x] + " ");
                    }
                    int ind = t[0];
                    //   System.out.println();
                    //  System.out.println("-------------------");
                    boolean cyc = false;
                    for (int x = 1; x < t.length - 1; x++) {
                        cyc = false;
                        if (t[x] == ind) {
                            cyc = true;
                            //  System.out.print("MATCH: " + t[x] + " " + ind + " ");
                            for (int y = x + 1; y < t.length - 1; y++) {
                                if (t[y] != t[y - x]) {
                                    x += y - x;
                                    cyc = false;
                                    break;
                                } else
                                    cyc = true;
                            }
                            if (cyc) {
                                // System.out.println();
                                System.out.println(x);
                                break;
                            }
                        }

                    }
                    if (!cyc) {
                        System.out.println(t.length - 1);
                    }
                    //  System.out.println();
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
        int[] t = new int[temp.length-1];
        for (int x = 1; x < temp.length; x++) {
            t[x-1] = toInt(temp[x]);
        }
        if (temp.length == 1) {
            return new int[1];
        }
        if (temp.length == 2) {
            System.out.println(0);
            return new int[0];
        }
        return t;
    }
}
