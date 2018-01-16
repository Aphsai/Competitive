/**
 * Created by Saksham on 2016-05-09.
 */

import java.util.*;
import java.io.*;
class Same {
    int less;
    int more;
    public Same () {}
}
public class StupendousBowties {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        HashMap<Integer, Same> xVal = new HashMap<>();
        HashMap<Integer, Same> yVal = new HashMap<>();
        int N = rInt();
        for (int x = 0;x < N; x++) {

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
