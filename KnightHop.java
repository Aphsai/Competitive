/**
 * Created by Saksham on 2016-03-22.
 */

import java.util.*;
import java.io.*;
class PairF {
    int X;
    int Y;
    public PairF(int x, int y) {
        X = x;
        Y = y;
    }
}
public class KnightHop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PairF src = new PairF(s.nextInt()-1,s.nextInt()-1);
        PairF dest = new PairF(s.nextInt()-1, s.nextInt()-1);
        System.out.print(src.X + " " + src.Y + " " + dest.X + " " + dest.Y);
        int[][] cache = new int[8][8];
        Queue<PairF> q = new ArrayDeque<>();
        q.add(src);
        cache[src.X][src.Y] = 1;
        while(!q.isEmpty()) {
            PairF cur = q.poll();
            int x = cur.X;
            int y = cur.Y;
            if (x == dest.X && y == dest.Y) {
                System.out.println(cache[x][y] -1);
                break;
            }//45 38
            try {
                if (cache[x-2][y-1] == 0) {
                    cache[x-2][y-1] = cache[x][y] + 1;
                    q.add(new PairF(x-2,y-1));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x-2][y+1] == 0) {
                    cache[x-2][y+1] = cache[x][y] + 1;
                    q.add(new PairF(x-2,y+1));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x+2][y-1] == 0) {
                    cache[x+2][y-1] = cache[x][y] + 1;
                    q.add(new PairF(x+2,y-1));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x+2][y+1] == 0) {
                    cache[x+2][y+1] = cache[x][y] + 1;
                    q.add(new PairF(x+2,y+1));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x-1][y-2] == 0) {
                    cache[x-1][y-2] = cache[x][y] + 1;
                    q.add(new PairF(x-1,y-2));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x+1][y-2] == 0) {
                    cache[x+1][y-2] = cache[x][y] + 1;
                    q.add(new PairF(x+1,y-2));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x-1][y+2] == 0) {
                    cache[x-1][y+2] = cache[x][y] + 1;
                    q.add(new PairF(x-1,y+2));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
            try {
                if (cache[x+1][y+2] == 0) {
                    cache[x+1][y+2] = cache[x][y] + 1;
                    q.add(new PairF(x+1,y+2));
                }
            }catch(ArrayIndexOutOfBoundsException e){}
        }
    }
}
