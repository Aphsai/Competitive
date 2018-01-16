/**
 * Created by Saksham on 2016-03-13.
 */
import java.util.*;
class Pair6 {
    int X;
    int Y;
    public Pair6(int x, int y) {
        this.X = x;
        this.Y = y;
    }
}
public class FortySeven {
    static Pair6 src;
    static Pair6 dest;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int x = 0; x < T; x++) {
            int C = s.nextInt();
            int R = s.nextInt();
            char [][] map = new char[R][C];
            int [][] val = new int[R][C];
            for (int y = 0; y < R; y++) {
                map[y] = s.next().toCharArray();
                for (int q = 0; q < C; q++) {
                    if (map[y][q] == 'W') {
                        dest = new Pair6(y,q);
                    }
                    if (map[y][q] == 'C') {
                        src = new Pair6(y,q);
                        val[y][q] = 1;
                    }
                }
            }
            Queue<Pair6> q = new ArrayDeque<>();
            q.add(src);
            while(!q.isEmpty()) {
                Pair6 cur = q.poll();
                if (cur.X != 0 && map[cur.X-1][cur.Y] == 'O') {
                    q.add(new Pair6(cur.X-1, cur.Y));
                    map[cur.X-1][cur.Y] = 'X';
                    val[cur.X-1][cur.Y] = val[cur.X][cur.Y] + 1;
                }
                else if (cur.X != 0 && map[cur.X-1][cur.Y] == 'W') {
                    System.out.println(val[cur.X][cur.Y] >= 60 ? "#notworth" : val[cur.X][cur.Y]);
                    break;
                }
                if (cur.X != R-1 && map[cur.X+1][cur.Y] == 'O') {
                    q.add(new Pair6(cur.X+1, cur.Y));
                    map[cur.X+1][cur.Y] = 'X';
                    val[cur.X+1][cur.Y] = val[cur.X][cur.Y] + 1;
                }
                else if (cur.X != R-1 && map[cur.X+1][cur.Y] == 'W') {
                    System.out.println(val[cur.X][cur.Y] >= 60 ? "#notworth" : val[cur.X][cur.Y]);
                    break;
                }
                if (cur.Y != 0 && map[cur.X][cur.Y-1] == 'O') {
                    q.add(new Pair6(cur.X, cur.Y-1));
                    map[cur.X][cur.Y-1] = 'X';
                    val[cur.X][cur.Y-1] = val[cur.X][cur.Y] + 1;
                }
                else if (cur.Y != 0 && map[cur.X][cur.Y-1] == 'W') {
                    System.out.println(val[cur.X][cur.Y] >= 60 ? "#notworth" : val[cur.X][cur.Y]);
                    break;
                }
                if (cur.Y != C-1 && map[cur.X][cur.Y+1] == 'O') {
                    q.add(new Pair6(cur.X, cur.Y+1));
                    map[cur.X][cur.Y+1] = 'X';
                    val[cur.X][cur.Y+1] = val[cur.X][cur.Y] + 1;
                }
                else if (cur.Y != C-1 && map[cur.X][cur.Y+1] == 'W') {
                    System.out.println(val[cur.X][cur.Y] >= 60 ? "#notworth" : val[cur.X][cur.Y]);
                    break;
                }
            }


        }
    }
}
