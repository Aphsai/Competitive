import java.util.*;
import java.io.*;
public class TwentyNinth {
    public static void main(String[] args) throws IOException {
//        Scanner s= new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        long K = Long.parseLong(token[2]);
        if (K == 0) {
            System.out.println(0);
            return;
        }
        long [] D = new long[N+1];
        for (int x = 0; x < M; x++) {
            token = br.readLine().split(" ");
            D[Integer.parseInt(token[0]) - 1] +=1;
            D[Integer.parseInt(token[1])] -= 1;
        }
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < D.length-1; x++) {
            total += D[x];
            D[x] = M-total;
            if (D[x] >= K) {
                System.out.println(1);
                return;
            }
            if (x!=0) {
                D[x] += D[x-1];
//                System.out.println(D[x]);
                if (D[x] >= K) {

                    if (x < min) {
                        min = x+1;
                    }
                }
            }
//            System.out.print(D[x] + " ");
        }
//        System.out.println(K);
        int left = 0;
        int right = 0;
//        while (D[right] <= K) {
//            right++;
//            if (right == D.length-1) {
//                System.out.println(-1);
//                        return;
//            }
//        }
//        while(true) {
//            System.out.println("LEFT: "+ left + " " + D[left] +  " RIGHT: " + right + " " + D[right]);
//            if (D[right] - D[left] <=K) {
//                right++;
//            }
//            else {
//                if (right - left < min) {
//                    min = right-left;
//                }
//                left++;
//            }
//            if (right == D.length-1)
//                break;
//        }
       outer: for (left = 0; left < D.length-1; left++) {
//            System.out.println("LEFT: "+ left + " " + D[left] +  " RIGHT: " + right + " " + D[right]);
            while(D[right] - D[left] < K) {
//                System.out.println("LEFT: "+ left + " " + D[left] +  " RIGHT: " + right + " " + D[right] + " DIFF: " + (D[right] - D[left]));
                right++;
                if (right >= D.length-1) {
            break outer;
                }
            }
            if (right-left <min) {
                min = right - left;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);

/*        for (int x = 0; x < D.length-2; x++) {
            total = 0;
            for (int y = x+1; y < D.length-1; y++) {
                if (D[y] - D[x] >= K) {
//                    System.out.println(D[y] - D[x]);
                    total++;
                    if (total < min) {
                        min = total;
                    }
                    break;
                }
                else {
//                    System.out.println(D[y] - D[x]);
                    if (total > min) {
                        break;
                    }
                    total++;
                }
            }
//            System.out.println("TOTAL: " + total);

*//*            int cur = 1;
            total = D[x];
            if (D[x] >= K) {
                System.out.println(1);
                return;
            }
            for (int y = x+1; y < D.length-1; y++) {
                if (cur > min) {
                    break;
                }
                if (total + D[y] < K) {
                    total += D[y];
                    cur++;
                }
                else {

                    cur++;
                    if (cur < min) {
                        min = cur;
                    }
                    break;
                }

            }*//*
        }*/
//        if (min == Integer.MAX_VALUE) {
//            System.out.println(-1);
//        }
//        else {System.out.println(min);}
    }
}