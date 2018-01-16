/**
 * Created by Saksham on 2016-04-13.
 */

import java.util.*;
import java.io.*;
class PairM {
    int x;
    int y;
    public PairM (int X, int Y) {
        x = X;
        y = Y;
    }
}
public class MazeGenerator {
    static BufferedReader br;
    static final int SIZE = 20;
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        Random random = new Random();
        int[][] maze = new int[SIZE][SIZE];
        LinkedList<int[]> q = new LinkedList<int[]>();
        int X = random.nextInt(SIZE);
        int Y= random.nextInt(SIZE);
        q.add(new int[] {X,Y,X,Y});
        while(!q.isEmpty()){
            int[] cur = q.remove(random.nextInt(q.size()));
            int x = cur[2];
            int y= cur[3];
            if (maze[x][y] == 0) {
                maze[cur[0]][cur[1]] = maze[x][y] = 1;
                if (x < SIZE-2 && maze[x + 2][y] == 0) {
                    q.add(new int[]{x+1,y,x+2,y});
                }
                if (x > 1 && maze[x - 2][y] == 0) {
                    q.add(new int[]{x-1,y,x-2,y});
                }
                if (y < SIZE-2   && maze[x][y + 2] == 0) {
                    q.add(new int[]{x,y+1,x,y+2});
                }
                if (y > 1 && maze[x][y - 2] == 0) {
                    q.add(new int[]{x,y-1,x,y-2});
                }
            }
        }

        for (int x =0 ; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                System.out.print(maze[x][y] == 0?"X":" ");
            }
            System.out.println();
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
