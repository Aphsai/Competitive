/**
 * Created by Saksham on 2016-09-18.
 */

import java.util.*;
import java.io.*;

public class Harambe {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int low = 0;
        int high = 0;
        for (int x = 0; x < arr.length;x++) {
         if(arr[x] > 64 && arr[x] < 91) high++;
            if (arr[x] >96 && arr[x] < 123) low++;
        }
        if (low > high) System.out.println(str.toLowerCase());
        else if (high > low) System.out.println(str.toUpperCase());
        else System.out.println(str);


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
