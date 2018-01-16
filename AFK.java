    /**
     * Created by Saksham on 2016-03-18.
     */
    import java.util.*;
    class PairB {
        int X;
        int Y;
        public PairB(int x, int y) {
            X = x;
            Y = y;
        }
    }
    public class AFK {
        public static void main(String[] args) {
            Scanner s= new Scanner(System.in);
            int T = s.nextInt();
            for (int x =0; x < T; x++) {
                int C = s.nextInt();
                int R = s.nextInt();
                PairB src = null;
                char[][] map = new char[R][C];
                int[][] cache = new int[R][C];
                for (int y =0; y < R; y++) {
                    map[y] = s.next().toCharArray();
                    for (int z = 0; z < C; z++) {
                       if (map[y][z] == 'C') {
                           src = new PairB(y,z);
                       }
                    }
                }
                Queue<PairB> Q = new ArrayDeque<>();
                Q.offer(src);
                cache[src.X][src.Y] = 1;
                while(!Q.isEmpty()) {
                    PairB cur = Q.poll();
                    int X = cur.X;
                    int Y = cur.Y;
                    if (cache[X][Y] >= 61) {
                        System.out.println("#notworth");
                        break;
                    }
                    if (map[X][Y] == 'W') {
                        System.out.println(cache[X][Y]-1);
                        break;
                    }
                    if (X != 0 && map[X-1][Y] != 'X' && cache[X-1][Y] == 0) {
                      cache[X-1][Y] = cache[X][Y] + 1;
                        Q.offer(new PairB(X-1,Y));
                    }
                    if (Y != 0 && map[X][Y-1] != 'X' && cache[X][Y-1] == 0) {
                        cache[X][Y-1] = cache[X][Y] + 1;
                        Q.offer(new PairB(X,Y-1));
                    }
                    if (X != R-1 && map[X+1][Y] != 'X' && cache[X+1][Y] == 0) {
                        cache[X+1][Y] = cache[X][Y] + 1;
                        Q.offer(new PairB(X+1,Y));
                    }
                    if (Y != C-1 && map[X][Y+1] != 'X' && cache[X][Y+1] == 0) {
                        cache[X][Y+1] = cache[X][Y] + 1;
                        Q.offer(new PairB(X,Y+1));
                    }
                }
//                for (int y = 0; y < R; y++) {
//                    for (int z = 0; z < C; z++) {
//                        System.out.print(cache[y][z] + " ");
//                    }
//                    System.out.println();
//                }
            }

        }
    }
