/**
 * Created by Saksham on 2016-03-20.
 */

import java.util.*;
import java.io.*;
 class PairP {
    long length;
     long paths;
     public PairP ( long len, long path){
         length = len;
         paths = path;
     }
}
public class ClareElstein {
    public static void main(String[] args) throws IOException{
      //  Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        ArrayList<Integer>[] map = new ArrayList[N+1];
        boolean[] ind = new boolean[N+1];
        HashSet<Integer> set = new HashSet<>();
        for (int x =0; x < M; x++) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            if (map[b] == null) {
                map[b] = new ArrayList<>();
            }
            map[b].add(a);
            ind[a]  = true;
        }

        PairP[] cache = new PairP[N+1];
        for (int x =1; x < N+1; x++) {
            if (ind[x] == false) {
                cache[x] = (new PairP(0, 1));
                continue;
            }
            else if (map[x] == null) {
                set.add(x);
                continue;
            }
        }
        for (int x  = N; x > 0; x--) {
           // System.out.println(x);;
            if (map[x] != null)
            for (int z: map[x]) {
                if (cache[z] == null) {
                    cache[z] = new PairP(cache[x].length + cache[x].paths, cache[x].paths);
                }
                else {
                    cache[z].length += (cache[x].length) + cache[x].paths;
                    cache[z].paths += cache[x].paths;
                }
                cache[z].paths %= 1000000007;
                cache[z].length %= 1000000007;
             //   System.out.println("CURRENT: " + z + " " + cache[z].length + " " + cache[z].paths);
            }
        }


        long total = 0;
        for (int x : set) {
            if (cache[x] != null) {
                total += cache[x].length;
            }
        }
        System.out.println(total%1000000007);
    }

}
