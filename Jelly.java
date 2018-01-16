/**
 * Created by Saksham on 2016-03-26.
 */

import java.util.*;
import java.io.*;
class PairH implements Comparable<PairH> {
    int x;
    int y;
    int z;
    int val;
    public PairH(int X, int Y, int Z, int VAL) {
        x = X;
        y = Y;
        z = Z;
        val = VAL;
    }
    public int compareTo(PairH a) {
        return val-a.val;
    }
}
public class Jelly {
    static BufferedReader br;
    static int[][][] map;
    static int[][][] dist;
    static int X;
    static int Y;
    static int Z;
    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        PairH src = null;
        token = br.readLine().split(" ");
        X = toInt(token[0]);
        Y = toInt(token[1]);
        Z = toInt(token[2]);
        int [][][] map = new int[Z][Y][X];
        int [][][] dist = new int[Z][Y][X];
        for (int z =0; z < Z; z++) {
            for (int y =0; y<Y; y++ ) {
              char[] temp = br.readLine().toCharArray();
                for (int x =0;x  < X; x++) {
                        if (temp[x] == 'J') {
                            src = new PairH(x, y, z, 0);
                        }
                    else {
                            map[z][y][x] = Character.getNumericValue(temp[x]);
                        }
                }
            }
        }
        PriorityQueue<PairH> q = new PriorityQueue<>();
        q.add(src);
        dist[src.z][src.y][src.x] = 1;
        int min = 0;
        while(!q.isEmpty()) {
            PairH cur = q.poll();
           // System.out.println(cur);
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
          //  System.out.println(x + " " + y + " " + z + " " + dist[z][y][x]);
            if ((z == Z-1 || y == Y-1 || x == X-1 || x == 0 || y == 0 || z == 0)) {
               System.out.println(dist[z][y][x]-1);     return;
            }
            if ((dist[z][y][x-1] == 0 || dist[z][y][x-1] > dist[z][y][x] + map[z][y][x-1])) {
                dist[z][y][x-1] = dist[z][y][x] + map[z][y][x-1]; q.add(new PairH(x-1,y,z, dist[z][y][x-1]));
            }
            if ((dist[z][y][x+1] == 0 || dist[z][y][x+1] > dist[z][y][x] + map[z][y][x+1])) {
                dist[z][y][x+1] = dist[z][y][x] + map[z][y][x+1];  q.add(new PairH(x+1,y,z, dist[z][y][x+1]));
            }
            if ((dist[z][y-1][x] == 0 || dist[z][y-1][x] > dist[z][y][x] + map[z][y-1][x])) {
                dist[z][y-1][x] = dist[z][y][x] + map[z][y-1][x]; q.add(new PairH(x,y-1,z, dist[z][y-1][x]));
            }
            if ((dist[z][y+1][x] == 0 || dist[z][y+1][x] > dist[z][y][x] + map[z][y+1][x])) {
                dist[z][y+1][x] = dist[z][y][x] + map[z][y+1][x];q.add(new PairH(x,y+1,z, dist[z][y+1][x]));
            }
            if ((dist[z-1][y][x] == 0 || dist[z-1][y][x] > dist[z][y][x] + map[z-1][y][x])) {
                dist[z-1][y][x] = dist[z][y][x] + map[z-1][y][x];   q.add(new PairH(x,y,z-1, dist[z-1][y][x]));
            }
            if ((dist[z+1][y][x] == 0 || dist[z+1][y][x] > dist[z][y][x] + map[z+1][y][x])) {
                dist[z+1][y][x] = dist[z][y][x] + map[z+1][y][x];  q.add(new PairH(x,y,z+1, dist[z+1][y][x]));
            }
        }
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
