/**
 * Created by Saksham on 2016-04-05.
 */

import java.util.*;
import java.io.*;

public class SketchleyPark {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        char[] main = br.readLine().toCharArray();
        ArrayList<Integer> check = new ArrayList<Integer>();
        for (int x = 0; x < main.length - 8; x++) {
            //   System.out.println(main[x] + " " + main[x+4] + " " + main[x+1] + " " main[x+8])
            if (main[x] == main[x+4] && main[x+1] == main[x+8] && main[x] != main[x+1] && main[x+1] != main[x+2] && main[x] != main[x+2] && main[x+2] != main[x+3] && main[x] != main[x+5] && main[x] != main[x+6] && main[x] != main[x+7]) {
                check.add(x);
                x+=8;
                //   System.out.println(x);
            }
        }
       // System.out.println(check);
        char[] key = {'H','A','I','L','H','Y','D','R','A'};
        int N = rInt();
        boolean tr = false;
        for (int i = 0; i < N; i++) {
            String cur =  br.readLine();
            char[] src = cur.toCharArray();
            HashMap<Character, Character> map = new HashMap<>(26);
            for (int x = 0; x < 26; x++) {
                map.put(src[x],(char)(65+x));

            }
            for (int ind : check) {
                if (map.get(main[ind]) == 'H' && map.get(main[ind+key.length-1]) == 'A') {
                    for (int y = 1; y < 9; y++) {
                        if (map.get(main[y + ind]) == key[y]) {
                            tr = true;
                        } else {
                            tr = false;
                            break;
                        }
                    }
                }
                if (tr) {
                    for (int y = 0; y < main.length; y++) {
                        System.out.print(map.get(main[y]));

                    }
                    return;
                }
            }

        }
        System.out.println("KeyNotFoundError");
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
