/**
 * Created by Saksham on 2016-05-03.
 */
import java.util.*;
import java.io.*;

public class MagicalSets {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = toInt(token[0]);
        int Q = toInt(token[1]);
        BitSet[] sets = new BitSet[N+1];
        for (int x = 0; x < N; x++) {
            token = read();
            int t = toInt(token[0]);
            sets[x+1] = new BitSet();
            for (int y =0 ; y < t; y++) {
                sets[x+1].set(toInt(token[y+1]) + 30);
            }
          //  System.out.println(sets[x+1]);
        }
        for (int x = 0; x < Q; x++) {
            int[] t = rIntAr();
            if (t[0] != 0) {
                BitSet temp = (BitSet) sets[t[1]].clone();
                for (int y = 2; y < t[0] + 1; y++) {
                    temp.xor(sets[t[y]]);
                    // System.out.println(sets[t[y]] + " " + temp);
                }
                System.out.print(temp.cardinality());
                int index = 0;
                int set = temp.nextSetBit(0);
                while (set != -1) {
                    System.out.print(" " + (set-30));
                    index = set + 1;
                    set = temp.nextSetBit(index);

                }
                System.out.println();
            }
            else {
                System.out.println(0);
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
