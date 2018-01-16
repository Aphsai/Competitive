/**
 * Created by Saksham on 2016-03-09.
 */
import java.util.*;
public class FortyTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true) {
            int N = s.nextInt();
                if (N == 0) {
                    break;
                }
                int[] map = new int[N];
                int[] dif = new int[N - 1];
                for (int x = 0; x < N; x++) {
                    map[x] = s.nextInt();
                    if (x != 0) {
                        dif[x - 1] = map[x] - map[x - 1];
//                    System.out.print(dif[x-1] + " ");
                    }
                }

//            System.out.println();
                int cl = 0;
                int pl = 0;
                int ind = 0;
                boolean zero = false;
                boolean cyc = false;
                boolean found = false;
//            for (int x = 0; x < N-1; x++) {
//                if (ind < 0) {
//                    System.out.println(cl);
//                    break;
//                }
                outer:
                while (ind != N - 1) {
                    for (int x = ind + 1; x < N - 1; x++) {
                        found = false;
                        if (dif[x] == dif[0]) {
                            found = true;
                            ind = x;
                            break;
                        }
                    }
//                System.out.println("INDEX: " + ind);
                    if (!found) {
                        System.out.println(N - 1);
                        break;
                    }
                    for (int x = 0; x < ind; x++) {
                        try {
                            if (dif[x] == dif[ind + x]) {
                                if (dif[x] == 0) {
                                    zero = true;
                                }
                                else
                                    zero = false;
                                cyc = true;
                            } else {
                                ind += x;
                                cyc = false;
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            if (cyc)
                                System.out.println(ind);
                            else
                                System.out.println(N - 1);
                            cyc = false;
                            break outer;
                        }
                    }
                    if (cyc == true) {
                        if (zero)
                            System.out.println(0);
                        else
                        System.out.println(ind);
                        break outer;
                    }
                }
//            System.out.println(Math.abs(ind) >= N-1?N-1:Math.abs(ind));
//                    System.out.println(y);
//                    if (y <0) {
//                        System.out.println(N-1);
//                        cyc = false;
//                        break;
//                    }
//                    if (dif[y] == dif[y-ind]) {
//                        cl++;
//                        cyc = true;
//                    }
//                    else {
//                        cyc = false;
//                        cl = 0;
//                        break;
//                    }
//                if (cyc) {
//                    System.out.println(cl);
//                    break;
//                }
            }
        }
    }
