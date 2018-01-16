/**
 * Created by Saksham on 2017-01-08.
 */

import java.util.*;
import java.io.*;

public class ProgressPie     {
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new FileReader("lazy_loading.txt"));
        pw = new PrintWriter (new FileWriter("out.txt"));
        int t = rInt();
        for (int x = 1; x < t+1; x++) {
            int N = rInt();
            int[] items = new int[N];
            for (int q = 0; q < N; q++) {
                items[q] = rInt();
            }
            Arrays.sort(items);

            int LP = 0;
            int RP = N-1;
            int trips = 0;
            while( LP <= RP) {
             //   System.out.println(LP + ":" + items[LP] + " " + RP + ":" + items[RP]);
                int pr = items[RP];
                int incr = 50/pr;
                if (incr <= RP-LP)
                    trips++;
                if (pr <= 50)
                LP += incr;
                RP -=1;
            }
            pw.println("Case #" + x +": " + trips);

        }
        pw.close();
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
