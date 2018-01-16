/**
 * Created by Saksham on 2016-04-12.
 */

import java.util.*;
import java.io.*;

public class HarbourMaster {
    static BufferedReader br;
    static int [][] crew;
    static int [] req;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        req = rIntAr();
        int N = rInt();
        crew = new int[N][3];
        for (int x =0 ; x < N; x++) {
            crew[x] = rIntAr();
        }
        double min = Integer.MIN_VALUE;
        if (N > 5) {
            for (int x = 0; x < N; x++) {
                for (int y = x + 1; y < N; y++) {
                    for (int z = y + 1; z < N; z++) {
                        for (int q = z + 1; q < N; q++) {
                            for (int w = q + 1; w < N; w++) {
                                double[] temp = new double[3];
                                temp[0] = crew[x][0] + crew[y][0] + crew[z][0] + crew[q][0] + crew[w][0];
                                temp[1] = crew[x][1] + crew[y][1] + crew[z][1] + crew[q][1] + crew[w][1];
                                temp[2] = crew[x][2] + crew[y][2] + crew[z][2] + crew[q][2] + crew[w][2];
                                double t = Math.min(temp[0] / (double)req[0], Math.min(temp[1] / (double)req[1], temp[2] / (double)req[2]));
                                min = Math.max(t, min);
                            }
                        }
                    }
                }
            }
        }
        else {
            double[] temp = new double[3];
            for (int x =0; x < N; x++) {
                temp[0] += crew[x][0];
                temp[1] += crew[x][1];
                temp[2] += crew[x][2];
                double t = Math.min(temp[0] / (double)req[0], Math.min(temp[1] / (double)req[1], temp[2] / (double)req[2]));
                min = Math.max(t, min);
            }
        }
        System.out.printf("%.1f", min*100>100?100.0:min*100);
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
