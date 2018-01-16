/**
 * Created by Saksham on 2016-03-13.
 */
import java.util.*;
public class FortyNinth {
    public static void main(String[] args){
        int max = 18;
        Scanner s = new Scanner(System.in);
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        for (int x =1; x < 19; x++) {
            map.put(x, new HashSet<Integer>());
        }
        map.get(2).add(6);
        map.get(3).add(4);
        map.get(3).add(6);
        map.get(3).add(15);
        map.get(3).add(5);
        map.get(1).add(6);
        map.get(4).add(3);
        map.get(4).add(6);
        map.get(4).add(5);
        map.get(5).add(3);
        map.get(5).add(4);
        map.get(5).add(6);
        map.get(6).add(2);
        map.get(6).add(1);
        map.get(6).add(3);
        map.get(6).add(4);
        map.get(6).add(5);
        map.get(6).add(7);
        map.get(7).add(6);
        map.get(7).add(8);
        map.get(8).add(7);
        map.get(8).add(9);
        map.get(9).add(8);
        map.get(9).add(12);
        map.get(9).add(10);
        map.get(10).add(11);
        map.get(11).add(10);
        map.get(11).add(12);
        map.get(12).add(11);
        map.get(12).add(13);
        map.get(12).add(9);
        map.get(13).add(12);
        map.get(13).add(14);
        map.get(13).add(15);
        map.get(14).add(13);
        map.get(15).add(3);
        map.get(15).add(13);
        map.get(16).add(17);
        map.get(16).add(18);
        map.get(17).add(16);
        map.get(17).add(18);
        map.get(18).add(17);
        map.get(18).add(16);
        while(true) {
            char com = s.next().charAt(0);
            if (com == 'i') {
                int a = s.nextInt();
                int b = s.nextInt();
                if (!map.containsKey(a)) {
                    map.put(a, new HashSet<Integer>());
                }
                if (!map.containsKey(b)) {
                    map.put(b, new HashSet<Integer>());
                }
                if (a > max) {
                    max = a;
                }
                if (b > max) {
                    max = b;
                }
                map.get(a).add(b);
                map.get(b).add(a);
            }
            else if (com == 'n') {
                System.out.println(map.get(s.nextInt()).size());
            }
            else if (com == 'f') {
                int a = s.nextInt();
                Set<Integer> track = new HashSet<Integer>();
                for (int i: map.get(a)) {
                    if (map.containsKey(i)) {
                        for (int x: map.get(i)) {
                            if (x != a && !map.get(a).contains(x)) {
                                track.add(x);
                            }
                        }
                    }
                }
                System.out.println(track.size());
            }
            else if (com == 'd') {
                map.get(s.nextInt()).remove(s.nextInt());
            }
            else if (com == 's') {
                Queue<Integer> q = new ArrayDeque<>();
                int a = s.nextInt();
                q.add(a);
                int [] cache = new int[max+1];
                int dest = s.nextInt();
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    if (cur == dest) {
                        break;
                    }
                    if (map.containsKey(cur)) {
                        for (int i : map.get(cur)) {
                            if (cache[i] == 0 || cache[i] > cache[cur] + 1) {
                                cache[i] = cache[cur] + 1;
                                q.add(i);
                            }

                        }
                    }
                }
                System.out.println(cache[dest] == 0? "Not connected": cache[dest]);
            }
            else
                break;


        }
    }
}
