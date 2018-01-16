///**
// * Created by Saksham on 2016-03-02.
// */
//import java.util.*;
//class Pair implements Comparable<Pair>{
//    int vert;
//    int weight;
//    public int compareTo (Pair a) {
//        if (a.weight < weight)
//            return 1;
//        else
//            return -1;
//    }
//    public Pair (int first, int second) {
//        vert = first;
//        weight = second;
////        System.out.println(first + " " + second);
//    }
//
//}
//public class ThirtyFirst {
//
//    public static void main(String[] args)  {
//        Scanner s = new Scanner(System.in);
//        int N = s.nextInt();
//        int K = s.nextInt();
//        ArrayList<Pair>[] map = new ArrayList[N+1];
////        HashMap<Integer,Set<Pair>> map = new HashMap<>();
//        for (int x = 1; x < N; x++) {
//            int b = s.nextInt();
////            if (!map.containsKey(x)) {
////                map.put(x, new HashSet<Pair>());
////            }
//            if (map[x] == null) {
//                map[x] = new ArrayList<Pair>();
//            }
//            if (map[x+1] == null) {
//                map[x+1] = new ArrayList<Pair>();
//            }
////            if (!map.containsKey(x+1)) {
////                map.put(x+1, new HashSet<Pair>());
////            }
////            map.get(x).add(new Pair(x+1, b));
////            map.get(x+1).add(new Pair(x, b));
//            map[x].add(new Pair(x+1,b));
//            map[x+1].add(new Pair(x, b));
//
//            if (x+K <= N) {
//                map[x].add(new Pair(x+K, 0));
////                map.get(x).add(new Pair(x + K, 0));
////                if (!map.containsKey(x+K)) {
////                    map.put(x+K, new HashSet<>());
////                }
//                if (map[x+K] == null){
//                    map[x+K] = new ArrayList<Pair>();
//                }
//                map[x+K].add(new Pair(x,0));
////                map.get(x+K).add(new Pair(x,0));
//            }
//        }
//        boolean [] visited = new boolean[N+1];
//        int [] weight = new int[N+1];
//        visited [1] = true;
//        int cur = 0;
//        int ind = 0;
//        int total = 0;
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        pq.addAll(map[1]);
//        ArrayList<Integer> ar = new ArrayList<>(N+1);
//        ar.add(1);
////        System.out.println("--------------------------");
//        while(ar.size() < N) {
////            for (int x = 0; x < ar.size(); x++) {
////                System.out.println("ARRAY: " + ar.get(x));
//
//                Pair temp = pq.poll();
//            while(true) {
//                if (!pq.isEmpty() && !visited[temp.vert]) {
////                    System.out.println(temp.weight + " " + temp.vert);
//                    break;
//                }
//                temp = pq.poll();
//            }
////            System.out.println("break");
////            System.out.println(temp.weight + " " + temp.vert);
//            /*12 3
//3 5 7 2 1 6 9 1 5 7 1
//*/
//                total += temp.weight;
//                visited[temp.vert] = true;
//                ar.add(temp.vert);
//                pq.addAll(map[temp.vert]);
////                for (Pair i : map.get(ar.get(x))) {
//////                    System.out.println("INDICE: " + i.vert + " " + i.weight);
////                    if (visited[i.vert] == false && i.weight < min) {
////                        min = i.weight;
////                        ind = i.vert;
////                    }
////                }
////            }
////            System.out.println(ind + " " + min);
////            total += min;
////            visited[ind] = true;
////            ar.add(ind);
//        }
//        System.out.println(total);
//    }
//}
