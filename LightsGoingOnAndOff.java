/**
 * Created by Saksham on 2016-05-14.
 */

import java.util.*;
import java.io.*;

public class LightsGoingOnAndOff {
    static BufferedReader br;
static int N;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        N = rInt();
        int K = rInt();
        int[] lights = new int[N];
        for (int x = 0; x < N; x++) {
            int shift = 0;
            token = read();
            for (int y = 0; y < K; y++) {
             //   System.out.print(shift + " ");
              //  System.out.print(token[y]);
                shift <<=1;
                if (token[y].equals("1")) shift |= 1;

            }
            lights[x] = shift;
           // System.out.println(lights[x]);
        }
        HashSet<Integer> last = new HashSet<>();
        int[] temp = new int[N];
        for (int x  =1; x < N; x++) {
            System.arraycopy(lights,0,temp,0, N);
//            for (int z = 0; z < N; z++) {
//           //    System.out.println(temp[z]);
//            }
            for (int y = x; y < N; y++) {
                temp[y] = temp[y - 1] ^ temp[y];
            }
         //   System.out.println(temp[N-1]);
            last.add(temp[N - 1]);
        }
        last.add(lights[N-1]);
        System.out.println(last.size());
    }
   // static HashSet<Integer> last = new HashSet<>();

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
