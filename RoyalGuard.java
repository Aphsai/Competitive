/**
 * Created by Saksham on 2016-03-24.
 */

import java.util.*;
import java.io.*;
public class RoyalGuard {
    public static void main(String[] args) throws IOException {
//        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = null;
        int N = toInt(br.readLine());
        HashMap<Integer, TreeSet<Integer>> hori = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> vert = new HashMap<>();
        for (int x = 0; x < N; x++) {
            t = br.readLine().split(" ");
            int a = toInt(t[0]);
            int b = toInt(t[1]);
            if (!vert.containsKey(b)) {
                vert.put(b, new TreeSet<>());
            }
            if (!hori.containsKey(a)) {
                hori.put(a, new TreeSet<>());
            }
            vert.get(b).add(a);
            hori.get(a).add(b);
        }
        int M = toInt(br.readLine());
        t = br.readLine().split(" ");
        long total = 0;
        int prevX = toInt(t[0]);
        int prevY = toInt(t[1]);
        for (int x = 1; x < M; x++) {
            t = br.readLine().split(" ");
            int newX = toInt(t[0]);
            int newY = toInt(t[1]);
         //   System.out.println(prevX + " " + prevY + " " + newX + " " + newY);
            if (prevX == newX) {
                if(hori.containsKey(prevX))
//                for (int i: hori.get(prevX)) {

                    if (prevY > newY) {           //System.out.println(i);
                        for (int i: hori.get(prevX).tailSet(prevY,true))
                        if (i >= newY) {
                            total++;
                        }
                        else {
                            break;
                        }

                    }
                    else {
                        for (int i: hori.get(prevX).tailSet(newY,true)) {
                            if (i >= prevY) {
                                total++;
                            } else {
                                break;
                            }
                        }

                    }

//                }
            }
            if (prevY == newY) {
                if (vert.containsKey(prevY))
//                for (int i: vert.get(prevY)) {

                    if (prevX > newX) { //System.out.println(i);
                        for (int i: vert.get(prevY).tailSet(prevX,true))
                        if (i >= newX) {
                            total++;
                        }
                        else {
                            break;
                        }

                    }
                    else {
                        for (int i: vert.get(prevY).tailSet(newX,true))
                        if (i >= prevX) {
                            total++;
                        }
                        else {
                            break;
                        }
                    }
//                }
            }
            prevX = newX;
            prevY = newY;

        }
        System.out.println(total);
    }
    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
