/**
 * Created by Saksham on 2016-03-28.
 */

import java.util.*;
import java.io.*;
class Rock {
    String s;
    int val;
    public Rock (String S) {
        s = S;
        calcVal();
    }
    public void replace(String s) {
        this.s = s;
    }
    public void calcVal() {
        char[] arr = s.toCharArray();
        for (int x = 0; x < arr.length; x++) {
            this.val += Character.getNumericValue(arr[x])-9;
        }
    }
}
public class Rocks {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        ArrayList<Rock> rocks = new ArrayList<>();
        int N = toInt(token[0]);
        for (int x = 0; x < N; x++) {
            token = br.readLine().split(" ");
            if (token[0].equals("A")) {
                rocks.add(new Rock(token[1]));
            }
            else if (token[0].equals("S")) {

            }
        }
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }
}
