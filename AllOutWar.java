/**
 * Created by Saksham on 2016-03-26.
 */

import java.util.*;
import java.io.*;

public class AllOutWar {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = toInt(token[0]);
        int Q = toInt(token[1]);
        int[] dif = new int[N];
//        token = br.readLine().split(" ");
//        for (int x =1; x < N;x++) {
//                dif[x] = toInt(token[x])-toInt(token[x-1]);
//        }
//        for (int x = 0; x < Q; x++) {
//
//        }
        System.out.println(Character.getNumericValue('a'));
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
