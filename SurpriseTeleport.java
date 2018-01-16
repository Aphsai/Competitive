/**
 * Created by Saksham on 2016-03-17.
 */
import java.util.*;
class PairA {
    int X;
    int Y;
    public PairA(int x, int y) {
        X = x;
        Y = y;
    }
}
public class SurpriseTeleport {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int R = s.nextInt();
        int C = s.nextInt();
        char[][] arr = new char[R][C];
        PairA SP = new PairA(s.nextInt(), s.nextInt());
        PairA DP = new PairA(s.nextInt(), s.nextInt());
        for (int x = 0; x < R; x++) {
            arr[x] = s.next().toCharArray();
        }
        PairA[] TP = new PairA[s.nextInt()];
        for (int x =0; x < TP.length; x++) {
            TP[x] = new PairA(s.nextInt(),s.nextInt());
            arr[TP[x].X][TP[x].Y] = 'T';
        }
        Queue<PairA> q= new ArrayDeque<>();
        q.add(SP);        int dist = 0;
        int dist2 =0;
        int [][] cache = new int[R][C];
        cache[SP.X][SP.Y]++;
        while(!q.isEmpty()) {
            PairA cur = q.poll();
            int x = cur.X;
            int y = cur.Y;
            if (dist == 0 && arr[x][y] == 'T') {
                dist = cache[x][y];
            }
            if (x == DP.X && y == DP.Y) {
                dist2 = cache[x][y];
                break;
            }
//            System.out.println(x + " " + y + " " + cache[x][y]);
            if (x != 0 && cache[x-1][y] == 0 && arr[x-1][y] != 'X') {
                cache[x-1][y] = cache[x][y] +1;
                q.add(new PairA(x-1,y));
            }
            if (x!= R-1 && cache[x+1][y] == 0 && arr[x+1][y] != 'X') {
                cache[x+1][y] = cache[x][y] +1;
                q.add(new PairA(x+1,y));
            }
            if (y != 0 && cache[x][y-1] == 0 && arr[x][y-1] != 'X') {
                cache[x][y-1] = cache[x][y] + 1;
                q.add(new PairA(x,y-1));
            }
            if (y != C-1 && cache[x][y+1] == 0 && arr[x][y+1] != 'X') {
                cache[x][y+1] = cache[x][y] + 1;
                q.add(new PairA(x,y+1));
            }
        }
        System.out.println(dist2 - dist);
    }

}

