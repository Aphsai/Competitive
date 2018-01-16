/**
 * Created by Saksham on 2016-03-02.
 */
import java.util.*;
import java.io.*;
public class ThirtySecond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] map = new ArrayList[N+1];
//        HashMap<Integer, Set<Integer>> map = new HashMap<>();\
        for (int x= 1; x < N; x++) {
            String[] token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
//            if (!map.containsKey(b)) {
//                map.put(b, new HashSet<Integer>());
//            }
            if (map[b] == null) {
                map[b] = new ArrayList<Integer>();
            }
            map[b].add(a);
        }
        int max = Integer.MIN_VALUE;
        int [] agr = new int[N+1];
        String[] token = br.readLine().split(" ");
        for (int x = 1; x < N+1; x++) {
            agr[x] = Integer.parseInt(token[x-1]);
            if (agr[x] > max) {
                max = agr[x];
            }
        }
        for (int i = 0; i < N; i++) {
            if (agr[N - i] > max) {
                max = agr[N - i];
            }
            if (map[N-i] != null) {
                for (int k : map[N - i]) {
                    agr[k] += agr[N - i];
                }
            }
        }
        System.out.println(max);


    }
}