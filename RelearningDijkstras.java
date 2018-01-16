/**
 * Created by Saksham on 2016-04-18.
 */

import java.util.*;
import java.io.*;
class PairO implements Comparable<PairO>{
    int x;
    int y;
    public PairO(int X, int Y) {
        x = X;
        y = Y;
    }
    public int compareTo(PairO a) {
        return y - a.y;
    }
}
public class RelearningDijkstras {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = null;
        int [] t = rIntAr();
        int N = t[0];
        int M = t[1];
        ArrayList<PairO>[] map = new ArrayList[N+1];
        for (int x = 0; x < M;x ++) {
            t = rIntAr();
            if (map[t[0]] == null) {
                map[t[0]] = new ArrayList<>();
            }
            if (map[t[1]] == null) {
                map[t[1]] = new ArrayList<>();
            }
            map[t[0]].add(new PairO(t[1], t[2]));
            map[t[1]].add(new PairO(t[0], t[2]));
        }
        int[] cache = new int[N+1];
        boolean[] vis = new boolean[N+1];
        PriorityQueue<PairO> set = new PriorityQueue<>();
        set.add(new PairO(1, 0));
        Arrays.fill(cache,-1);
        cache[1] = 0;
            while(!set.isEmpty()) {
                PairO src = set.poll();
                int cur = src.x;
                if (map[cur] != null)
                for (PairO i : map[cur]) {
                    if ((cache[i.x] > cache[cur] + i.y || cache[i.x] == -1)) {
                        cache[i.x] = cache[cur]+ i.y;
                        if (!set.contains(i))
                        set.add(i);
                    }
                }
            }
            for (int x = 1; x < N+1; x++) {
                System.out.println(cache[x]);
            }
        }
        /*
        	vector<int> dist  (N+1, 0x3f3f3f3f);
	vector<bool> vis (N+1);
	int ind = src;
	while(ind != 0) {
		int cur = ind;
		vis[cur] = true;
		ind = 0;
		int add = 0;
		for (int x  = 1; x < N+1; x++) {
			if (vis[x] == false && (dist[x] > dist[cur] + cache[cur][x] || dist[x] == 0)) {
				dist[x] = dist[cur] + cache[cur][x];
				if (dist[x] < add || add == 0) {
					ind = x;
					add = dist[x];
				}
			}
		}
	}
         */

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
