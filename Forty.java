/**
 * Created by Saksham on 2016-03-07.
 */
import java.util.*;
class Pair2 {
    int first;
    int second;
    Pair2(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Forty {
    static int total;
    static int N;
    static int [][] results;
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        for (int x = 0; x < 10; x++) {
            total =0;
            N = s.nextInt();
//            System.out.println(N);
            int total = 0;
            Pair2[] cards = new Pair2[N];
            results = new int[N][N];
            for (int y = 0;y  < N; y++) {
                cards[y] = new Pair2(s.nextInt(), s.nextInt());
                total += cards[y].first;
            }
            int index = -1;
            int start = 0;
//            while(index < N) {
//                index = lowest(cards, index+1, 5);
//                for (int y =start; y < index; y++) {
//                    System.out.println(cards[y].first + " " + cards[y].second);
//                    total += cards[y].first + cards[y].second;
//
//                }
//                if (index == N && index - start == 5) {
//                    total -= cards[N-1].second + 1;
//                }
//                if (index != N) {
//                    total += cards[index].first - 1;
//                    System.out.println(cards[index].first + " " + cards[index].second + " TOTAL " + total);
//                }
//                start = index+1;
//                System.out.println("-------------");
//            }
            System.out.println(total + lowest(cards,0,0,""));
        }
    }
    /*
    6
    8 3
    4 5
    3 1
    2 2
    6 7
    2 3
     */
    public static int lowest(Pair2 [] ar, int count, int index, String str) {
         if (index >= N) {
             return 0;
         }
//        System.out.print(str);
        if (results[index][count] != 0) return results[index][count];
        if (count == 4) {
            return lowest(ar, 0, index+1,"")-1;

        }
        else
            return results[index][count] = Math.max(ar[index].second + lowest(ar, count+1,index+1,ar[index].second+" "), lowest(ar,0, index+1,"")-1);
//        int min = Integer.MAX_VALUE;
//        int index = 0;
//            if (x+y == N) {
//                y++;
////                total -= ar[N-1].second + 1;
//            }
////            if (x+y == N+1) {
////                total -= ar[N-1].second + 1;
////            }
//        try {
//            for (int z = x; z < x + y; z++) {
//                if (ar[z].second <= min || ar[z].second-1 == min) {
//                    min = ar[z].second;
//                    index = z;
//                }
//            }
//        }catch (ArrayIndexOutOfBoundsException e) {
////                        if (x+y == N) {
////                total -= ar[N-1].second + 1;
////            }
////            System.out.println("ENTERED " + index);
//            return N;
//        }
////        System.out.println("INDEX: " + index);
//
//        return index;
    }
}
