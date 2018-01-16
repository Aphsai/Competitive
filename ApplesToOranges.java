/**
 * Created by Saksham on 2016-03-31.
 */

import java.util.*;
import java.io.*;
class PairK {
    int type;
    double val;
    public PairK(int s, double VAL) {
        type = s;
        val = VAL;
    }
}
public class ApplesToOranges {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = read();
        int N = toInt(token[0]);
        int M = toInt(token[1]);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<PairK>[] arr = new ArrayList[N+1];        double[] cache = new double[N+1];
        for (int x = 0; x < N; x++) {
                map.put(br.readLine(), x+1);
                arr[x+1] = new ArrayList<>();
                cache[x+1] = 1;
        }

        for (int x = 0; x < M; x++) {
            token = read();
            arr[map.get(token[0])].add(new PairK(map.get(token[1]), Double.parseDouble(token[2])));
        }
        int src = map.get("APPLES");
        Queue<PairK> q = new ArrayDeque<>();
        boolean [] vis = new boolean[N+1];
        q.add(new PairK(src,0));
        cache[src] = 1;
        while(!q.isEmpty()) {
            PairK cur = q.poll();
            int type = cur.type;
            vis[type] = true;
          //  System.out.println(cache[type] + " " + type);
            if (type == src && cache[type] > 1.1) {
                System.out.println("YA");
                return;
            }
            for (PairK i: arr[type]) {
               // System.out.println(i.type);
                if (cache[i.type] < cache[type]*i.val || !vis[i.type]) {
                    cache[i.type] = cache[type]*i.val;
                    q.add(i);
                }

            }
        }
        System.out.println("NAW");


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
}
