///**
// * Created by Saksham on 2016-03-05.
// */
//import java.util.*;
//import java.io.*;
//class Pair {
//    int r;
//    int c;
//    public Pair(int r, int c) {
//        this.r = r;
//        this.c= c;
//    }
//}
//public class ThirtySeventh {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for (int x = 0; x < T; x++) {
//            int R = Integer.parseInt(br.readLine());
//            int C = Integer.parseInt(br.readLine());
//            char[][] maze = new char[R][C];
//            int[][] dist = new int[R][C];
//            for (int y = 0; y < R; y++) {
//                maze[y] = br.readLine().toCharArray();
//            }
//            Queue<Pair> q = new ArrayDeque<>();
//            q.offer(new Pair(0,0));
//            dist[0][0] = 1;
////            for (int y = 0; y < R; y++) {
////                for (int w= 0; w < C; w++) {
////                    System.out.print(maze[y][w]);
////                }
////                System.out.println();
////            }
//
//            while (!q.isEmpty()) {
//                Pair cur = q.poll();
////                System.out.println (cur.r + " " + cur.c + " " + dist[cur.r][cur.c]);
//
//                    if (maze[cur.r][cur.c] == '+' || maze[cur.r][cur.c] == '|') {
////                        System.out.println("IN");
//                        if (cur.r != R-1 && dist[cur.r + 1][cur.c] == 0 && maze[cur.r + 1][cur.c] != '*') {
//                            dist[cur.r + 1][cur.c] = dist[cur.r][cur.c] + 1;
//                            q.add(new Pair(cur.r + 1, cur.c));
//                        }
//                        if (cur.r != 0 && dist[cur.r - 1][cur.c] == 0 && maze[cur.r - 1][cur.c] != '*') {
//                            dist[cur.r - 1][cur.c] = dist[cur.r][cur.c] + 1;
//                            q.add(new Pair(cur.r - 1, cur.c));
//                        }
//                    }
//                if (maze[cur.r][cur.c] == '+' || maze[cur.r][cur.c] == '-') {
////                    System.out.println("IN2");
//                    if (cur.c !=0 && dist[cur.r][cur.c - 1] == 0 && maze[cur.r][cur.c - 1] != '*') {
//                            dist[cur.r][cur.c - 1] = dist[cur.r][cur.c] + 1;
//                            q.add(new Pair(cur.r, cur.c - 1));
//                        }
//                        if (cur.c != C-1 && dist[cur.r][cur.c + 1] == 0 && maze[cur.r][cur.c + 1] != '*') {
//                            dist[cur.r][cur.c + 1] = dist[cur.r][cur.c] + 1;
//                            q.add(new Pair(cur.r, cur.c + 1));
//                        }
//                    }
//
//
//            }
//            if (dist[R-1][C-1] == 0) {
//                System.out.println(-1);
//            }
//            else
//            System.out.println(dist[R-1][C-1]);
//        }
//    }
//}
