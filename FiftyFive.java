///**
// * Created by Saksham on 2016-03-14.
// */
//import java.math.BigInteger;
//import java.util.*;
//import java.io.*;
//
//public class FiftyFive {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        Scanner s = new Scanner(System.in);
//        int N = Integer.parseInt(br.readLine());
//        String[] token = br.readLine().split(" ");
//        BigInteger[] arr = new BigInteger[N];
//        BigInteger[] arr2 = new BigInteger[N];
//        for (int x = 0; x < N; x++) {
//            arr[x] = new BigInteger(token[x]);
//            arr2[x] = new BigInteger("0");
//        }
//        int M = Integer.parseInt(br.readLine());
//        for (int  y = 1; y < N; y++) {
//                for (int x = y; x > 0; x--) {
//                    System.out.print(x + " " + (y-x);
//                    arr2[y] = arr2[y].add(arr[y-x].multiply(new BigInteger((x+1)*(M-1) + "")));
//                    System.out.print(arr2[y] + " ");
//                }
//            arr2[y] = arr2[y].add(arr[y]);
////            System.out.println();
//        }
//        arr2[0] = arr[0];
//        BigInteger mod = new BigInteger(((int)Math.pow(10,9) + 7) + "");
//        for (int x = 0; x < N; x++) {
//            System.out.print((arr2[x].mod(mod) + " " ));
//        }
//    }
//}
