/**
 * Created by Saksham on 2016-03-21.
 */

import java.util.*;
import java.io.*;
class Used {
    boolean[] used = new boolean[4];
    int cur;
    public Used(int x, int y) {
        used[x] = true;
        cur = y;
    }
    public Used(boolean[] use, int x, int y) {
        System.arraycopy(use, 0, used, 0, 4);
        cur = x;
        used[y] = true;
    }
    public Used() {

    }
    public boolean hit() {
        int count = 0;
        for (int x = 0; x < 4; x++) {
            if (used[x])count++;
            else break;
        }
        if (count == 4) return true;
        return false;
    }
    public void display() {
        System.out.print(cur + " ");
        for (int x = 0; x < 4; x++) {
            System.out.print(used[x] + " " );
        }
        //System.out.println(dec());
        //System.out.println();
    }
    public int dec() {
        int shift = 0;
        for (int x =0; x < 4; x++) {
            shift <<= 1;
            shift |= (used[x]?1:0);
        }
        return shift;
    }
}
public class TwentyFour {
    static int [] cards;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            Queue<Used> q = new ArrayDeque<Used>();
            Queue<Used> hold = new ArrayDeque<>();
            cards = new int[4];
            for (int x =0; x < 4; x++) {
                cards[x] = s.nextInt();
            }
            int max = 0;
//            Queue<Integer> q = new ArrayDeque<>();
            for (int x =0; x < 4; x++) {
                    q.add(new Used(x, cards[x]));
            }
            HashSet<Integer>[] set = new HashSet[15];
            for (int x =1 ; x < 15; x++) {
                set[x] = new HashSet<>();
            }
            while(!q.isEmpty()) {
                Used cur = q.poll();

                //cur.display();
                if (!cur.hit()) {
                    set[cur.dec()].add(cur.cur);
                    for (int x = 0; x < 4; x++) {
                        if (!cur.used[x]) {
                            q.add(new Used(cur.used, cur.cur + cards[x], x));
                        }
                    }
                    for (int x = 0; x < 4; x++) {
                        if (!cur.used[x]) {
                            q.add(new Used(cur.used, cur.cur - cards[x], x));
                        }
                    }
                    for (int x = 0; x < 4; x++) {
                        if (!cur.used[x] && cur.cur % cards[x] == 0) {
                            q.add(new Used(cur.used, cur.cur / cards[x], x));
                        }
                    }
                    for (int x = 0; x < 4; x++) {
                        if (!cur.used[x]) {
                            q.add(new Used(cur.used, cur.cur * cards[x], x));
                        }
                    }
                    continue;
                }
                else {
                    if (cur.cur < 25) max = Math.max(max, cur.cur);
                }
            }
            for (int x = 1; x < 9; x++) {
                max = Math.max(max, max(set[x], set[15-x]));
            }
            System.out.println(max);

        }
    }
    static int max(HashSet<Integer> a, HashSet<Integer> b) {
        int max = 0;
        int hold = 0;
        for (int x : a) {
            for (int y : b) {
                hold = x + y;
                if (hold < 25) max = Math.max(hold, max);
                hold = x * y;
                if (hold < 25) max = Math.max(hold, max);
                hold = x - y;
                if (hold < 25) max = Math.max(hold, max);
                if (y != 0 && x%y == 0) {
                    hold = x/y;
                    if (hold < 25) max = Math.max(hold, max);
                }
            }
        }
        for (int x : b) {
            for (int y : a) {
                hold = x - y;
                if (hold < 25) max = Math.max(hold, max);
                if (y!=0 && x%y == 0) {
                    hold = x/y;
                    if (hold < 25) max = Math.max(hold, max);
                }
            }
        }
        return max;
    }
}