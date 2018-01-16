/**
 * Created by Saksham on 2016-05-25.
 */

import java.util.*;
import java.io.*;
class Direction {
    boolean N, S, E, W;
    public void tr(char x) {
        if (x == 'N') N = true;
        else if (x == 'S') S = true;
        else if (x == 'E') E = true;
        else W = true;
    }
    public boolean ret(char x) {
        if (x == 'N') return N;
        else if (x == 'S') return S;
        else if (x == 'E') return E;
        else return W;
    }
}
public class CarsOnIce {
    static BufferedReader br;
    static char[][] map;
    static Direction[][] check;
    static int N, M;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);
        map = new char[N][M];
        check = new Direction[N][M];
        for (int x =0 ;x  < N; x++) {
            map[x] = br.readLine().toCharArray();
            for (int y =0; y < M; y++) {
                check[x][y] = new Direction();
            }
        }
        for (int x =0; x < N; x++) {
            for (int y =0; y < M; y++) {
                if (map[x][y] != '.') untilClear(y, x, map[x][y]);
            }
        }
    }

    public static void untilClear(int x, int y, char dir) {
        if (dir == 'N') {//NORTH
            for (int z = y; z > 1; z--) {
                if (map[z-1][x] != '.') {
                    untilClear(x, z-1, map[z-1][x]);
                    continue;
                }
                else {
                    if (check[0][x].ret(map[y][x])) break;
                  //  else check[z-1][x].tr(map[y][x]);
                }
            }
            check[0][x].tr(map[y][x]);
        }
        else if (dir == 'S') {//SOUTH
            for (int z = y; z < N-1; z++) {
                if (map[z+1][x] != '.') {
                    untilClear(x, z+1, map[z+1][x]);
                    continue;
                }
                else {
                    if (check[N-1][x].ret(map[y][x])) break;
                    //else check[z-][x].tr(map[y][x]);
                }
            }
            check[N-1][x].tr(map[y][x]);

        }
        else if (dir == 'E') {//EAST
            for (int z = x; z < M-1; z++) {
                if (map[y][z+1] != '.') {
                    untilClear(z+1, y, map[y][z+1]);
                    continue;
                }
                else {
                    if (check[y][M-1].ret(map[y][x])) break;
                  //  else check[y][z+1].tr(map[y][x]);
                }
            }
            check[y][M-1].tr(map[y][x]);
        }
        else {//WEST
            for (int z = x; z > 1; z--) {
                if (map[y][z-1] != '.') {
                    untilClear(z-1, y, map[y][z-1]);
                    continue;
                }
                else {
                    if (check[y][0].ret(map[y][x])) break;
                   // else check[y][z-1].tr(map[y][x]);
                }
            }
            check[y][M-1].tr(map[y][x]);
        }
        map[y][x] = '.';
        System.out.println("(" + y +","+x+")");
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
