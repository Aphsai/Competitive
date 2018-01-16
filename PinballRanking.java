/**
 * Created by Saksham on 2016-05-21.
 */

import java.util.*;
import java.io.*;
class Node {
    Node left;
    Node right;
    int data;
    int pos;

        public Node(int x) {
            data = x;
        }
}
public class PinballRanking {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = rInt();
        long total = 1;

        Node root = new Node(rInt());
        root.pos = 1;
        for (int x =0; x < N-1; x++) {
            Node cur = root;

            Node parent = null;
            int set = rInt();

            while (cur != null) {
                parent = cur;
                if (set > cur.data) {
                    parent.pos++;
                    cur = cur.right;
                }
                else {
                    cur = cur.left;
                }
            //    System.out.print(parent.data + " " + parent.pos);
             //   if (cur != null) System.out.print(" " + cur.data);
             //  System.out.println();
            }

            cur = new Node(set);

            if (set > parent.data) {
                parent.right = cur;
                cur.pos = parent.pos-1;
            }
            else {
                parent.left = cur;
                cur.pos = parent.pos + 1;
            }
        //   System.out.println(cur.pos);
        //   System.out.println("-------------------");
            total += cur.pos;

        }System.out.println(total/N);
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
