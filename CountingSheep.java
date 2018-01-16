/**
 * Created by Saksham on 2016-04-09.
 */

import java.util.*;
import java.io.*;

public class CountingSheep {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        br = new BufferedReader(new FileReader("P1.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("out.out"));
        int N = rInt();
        for (int x = 1; x < N+1; x++) {
            int b = rInt();
            if (b == 0) {
                pw.println("Case #" + x + ": " + "INSOMNIA");
            }
            else {
                HashSet<Character> reached = new HashSet<>();
                int held = 0;
                while (true) {
                    held++;
                    int z = b*held;
                    char[] num = String.valueOf(z).toCharArray();
                    for (int y = 0; y < num.length; y++) {
                        reached.add(num[y]);
                    }
                    if (reached.size() == 10) {
                        pw.println("Case #" + x + ": " + z);
                        break;
                    }
                }
            }
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
