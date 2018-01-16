/**
 * Created by Saksham on 2016-03-10.
 */
import java.util.*;
import java.io.*;
class Time {
    long S;
    long E;
    long H;
    public Time(long S, long E, long H) {
        this.S = S;
        this.H = H;
        this.E = S+E;
    }
}
public class FortyFour {
    static long [] cache;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Time[] time = new Time[N];
//        cache = new long[N];
        boolean[] ch = new boolean[N];
        for (int x =0 ; x < N; x++) {
            String[] token = br.readLine().split(" ");
            time[x] = new Time(Long.parseLong(token[0]), Long.parseLong(token[1]), Long.parseLong(token[2]));
        }
        System.out.println(bfs(time,N,Long.MAX_VALUE, Long.MAX_VALUE));
    }
    static long bfs(Time[] time, int n, long s, long e) {
        if (n == 0) {
            return 0;
        }
//        if (cache[n-1] != 0)
//            return cache[n-1];
        if (time[n-1].E > s ) {
            return (bfs(time, n - 1, s, e));
        }
        else
            return Math.max(time[n-1].H + bfs(time,n-1,time[n-1].S,time[n-1].E), bfs(time,n-1,s,e));
    }
}