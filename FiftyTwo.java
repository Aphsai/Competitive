/**
 * Created by Saksham on 2016-03-14.
 */
import java.util.*;
 class Inter implements Comparable<Inter> {
    int S;
     int E;
     public Inter(int X, int Y) {
         S = X;
         E = Y;
     }
     public int compareTo(Inter a) {
         return this.E - a.E;
     }

}
public class FiftyTwo {
    static Inter[] arr;
    static int T;
    static int N;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int M = s.nextInt();
        T = s.nextInt();
        arr = new Inter[M];
        for (int x = 0; x < M; x++) {
            int a= s.nextInt();
            int b = s.nextInt();
            arr[x] = new Inter(a, a+b);
        }
        if (M == 0) {
            System.out.println(0);
            return;
        }
        Inter[] mic = new Inter[N];
        for (int x =0; x < N; x++) {
            mic[x] = arr[x];
            System.out.println(mic[x].S + " " + mic[x].E);
        }
        int index = N;
        while(true){
            Arrays.sort(mic);
            for (int x =0 ; x < N; x++) {
                try {
//                    System.out.println(mic[x].E + " " + arr[index].S);
                    if (mic[x].E == 0) {
                        mic[x] = arr[index];
                        index++;
                    }
                    if (mic[x].E + T <= arr[index].S) {
                        System.out.println(mic[x].E);
                        return;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {System.out.println("ENTERED: " + mic[x-1].E); return;}
            }
            mic[0] = new Inter(arr[index].S, mic[0].E+arr[index].E);
            index++;
            if (index == N) {
                break;
            }


        }
    }
//    static int recurse (int n) {
//        if (n == N)
//            return 0;
//        if (arr[n].E + T > arr[n+1].S) {
//            return recurse(n+1);
//        }
//    }
}
