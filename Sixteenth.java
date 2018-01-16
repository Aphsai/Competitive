/**
 * Created by Saksham on 2016-02-24.
 */
import java.util.*;
import java.io.*;
public class Sixteenth {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        int T = Integer.parseInt(token[2]);
       int [][] arr = new int [N+1][N+1];
        for (int x =0 ; x < N; x++) {
            for (int y =0; y < N; y++) {
                arr[x+1][y+1] = Integer.MAX_VALUE/2;
                if (x == y) {
                    arr[x+1][y+1] = 0;
                }
            }
        }
        for (int x =0; x < M; x++) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            arr[a][b] = T;
        }
        for (int x =1 ; x < N+1; x++) {
            for (int y = 1; y < N+1; y++) {
                for (int z = 1; z < N+1; z++) {
                    if (arr[y][z] > arr[y][x] + arr[x][z]) {
                        arr[y][z] = arr[y][x] + arr[x][z];
                    }
                }
            }
        }
        int Q = Integer.parseInt(br.readLine());

        for (int x =0 ;x  < Q; x++) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            if (arr[a][b] == 1073741823) {
                System.out.println("Not enough hallways!");
            }
            else
            System.out.println(arr[a][b]);
            /*
            Queue<Integer> q = new ArrayDeque<Integer>();
            q.offer(a);
            int min = 0;
           int [] cache = new int[N+1];
//            for (int y = 0;y  < N; y++) {
//                cache[y] = Integer.MAX_VALUE;
//            }
            boolean [] visited = new boolean[N+1];
            visited [a] = true;
            while(!q.isEmpty()) {
                int source = q.poll();
                if (cache[source] > min) {
                    min = cache[source];
                }
                if (source == b) {
                    break;
                }
                if (map.containsKey(source)) {
                    for (int i : map.get(source)) {
                        if (visited[i] == false && cache[i] < cache[source] + T) {
                            cache[i] = cache[source] + T;
                            q.offer(i);
                            visited[i] = true;
                        }
                    }
                }
            }*/

        }
    }
}
