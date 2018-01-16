/**
 * Created by Saksham on 2016-03-12.
 */
import java.util.*;
class Pair5 {
    int x;
    int y;
    public Pair5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class FortyFive {
    static char[][] map;
    static int R;
    static int C;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> set = new ArrayList<>();
        int N = s.nextInt();
        R = s.nextInt();
        C = s.nextInt();
        map = new char[R][C];
        for (int x = 0; x < R; x++) {
            map[x] = s.next().toCharArray();
        }
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] == '.') {
//                    System.out.println(x + " " + y);
                    set.add(bfs(map, x, y));
                    map[x][y] = 'I';
                }
            }
        }
//        System.out.println(set);
        int rooms = 0;
        Collections.sort(set, Collections.reverseOrder());
        for (int i : set) {
            if (i <= N) {
                N-= i;
                rooms++;
            }
            else {
                break;
            }
        }
        if (rooms == 1) {
            System.out.println(rooms + " room, " + N + " square metre(s) left over");
        } else
            System.out.println(rooms + " rooms, " + N + " square metre(s) left over");

    }
    static int bfs(char[][] map,int x,int y) {
        Queue<Pair5> q = new ArrayDeque<>();
        q.add(new Pair5(x,y));
        int total = 0;
        while(!q.isEmpty()) {
            Pair5 src = q.poll();
            if (src.y != C-1 && map[src.x][src.y+1] == '.') {
                q.add(new Pair5(src.x,src.y+1));
                total++;
                map[src.x][src.y+1] = 'I';
            }
            if (src.x != R-1 && map[src.x+1][src.y] == '.') {
                q.add(new Pair5(src.x+1,src.y));
                total++;
                map[src.x+1][src.y] = 'I';
            }
            if (src.x != 0 && map[src.x-1][src.y] == '.') {
                q.add(new Pair5(src.x-1,src.y));
                total++;
                map[src.x-1][src.y] = 'I';
            }
            if (src.y != 0 && map[src.x][src.y-1] == '.') {
                total++;
                q.add(new Pair5(src.x,src.y-1));
                map[src.x][src.y-1] = 'I';
            }

        }
        FortyFive.map = map;
        if (total == 0)
            return 1;
        return total;
    }

}
