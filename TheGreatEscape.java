/**
 * Created by Saksham on 2016-03-23.
 */

import java.util.*;
import java.io.*;
class Tuple {
      int x;
    int y;
    int z;
    public Tuple(int X, int Y, int Z) {
        x = X;
        y = Y;
        z = Z;
    }
        }
public class TheGreatEscape {
    static int[][][] map;
    static int W;
    static int L;
    static int H;
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        W = toInt(token[0]);
        L = toInt(token[1]);
        H = toInt(token[2]);
        int N = toInt(br.readLine());
        map = new int[W+1][L+1][H+1];
        for (int x =0; x < N; x++) {
            token = br.readLine().split(" " );
            int a = toInt(token[0]);
            int b = toInt(token[1]);
            int c = toInt(token[2]);
            map[a][b][c] = -1;
        }
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(1,1,1));
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int x = t.x;
            int y = t.y;
            int z = t.z;
            if (valid(x-1,y,z)) {
                map[x-1][y][z] = map[x][y][z] + 1;
                q.add(new Tuple(x-1,y,z));
            }
            if (valid(x+1,y,z)) {
                map[x+1][y][z] = map[x][y][z] + 1;
                q.add(new Tuple(x+1,y,z));
            }
            if (valid(x,y-1,z)) {
                map[x][y-1][z] = map[x][y][z] + 1;
                q.add(new Tuple(x,y-1,z));
            }
            if (valid(x,y+1,z)) {
                map[x][y+1][z] = map[x][y][z] + 1;
                q.add(new Tuple(x,y+1,z));
            }
            if (valid(x,y,z-1)) {
                map[x][y][z-1] = map[x][y][z] + 1;
                q.add(new Tuple(x,y,z-1));
            }
            if (valid(x,y,z+1)) {
                map[x][y][z+1] = map[x][y][z] + 1;
                q.add(new Tuple(x,y,z+1));
            }

        }
        int min = Integer.MAX_VALUE;
        for (int x = W-2; x < W+1;x++) {
            for (int z= H-2; z < H+1; z++) {
                if (map[x][L][z] < min && map[x][L][z] != -1) {
                    min = map[x][L][z];
                }
            }
        }
        System.out.println(min);

    }
    static boolean valid(int x,int y,int z) {
        return (x >0  && y >0 && z >0&& x < W+1 && y < L+1 && z < H+1 && map[x][y][z] == 0);
    }
        static int toInt(String s) {
            return Integer.parseInt(s);
        }
}
