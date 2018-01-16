/**
 * Created by Saksham on 2016-05-07.
 */

import java.util.*;
import java.io.*;
class TrieNode {
    HashMap<Character, TrieNode> map = new HashMap<>();
    public String toString() {
        String temp = "";
        for (Character i: map.keySet()) {
            temp += i + " ";
        }
        return temp;
    }
}
public class Autocomplete {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int T = rInt();
        for (int i = 0; i < T; i++) {
            int N = rInt();
            TrieNode root = new TrieNode();
            int total = 0;
            for (int x = 0; x < N; x++) {
                char[] str = br.readLine().toCharArray();
                StringBuilder string = new StringBuilder();
                boolean reached = false;
                TrieNode temp = root;
                for (int z = 0; z < str.length; z++) {
                    if (temp.map.containsKey(str[z])) {
                        //System.out.println("HAS: " + total + " " + temp);
                        temp = temp.map.get(str[z]);
                    }
                    else {
                        if (!reached)
                            total += z+1;
                        reached = true;
                        temp.map.put(str[z], new TrieNode());
                      //  System.out.println("ADD: " + total + " " + temp);
                        temp = temp.map.get(str[z]);

                    }
                }
                if (!reached) {
                    total += str.length;
                }
            }
            System.out.printf("Case #%d: %d\n", (i+1), total);
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