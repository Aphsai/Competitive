///**
// * Created by Saksham on 2016-03-14.
// */
//import java.util.*;
//public class FiftyFour {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int N = s.nextInt();
//        int[] lim = new int[N];
//        int[] lims = new int[N];
//        for (int x =0; x < N; x++) {
//            int a= s.nextInt();
//            lim[x] = a;
//            lims[x] = a;
//        }
//        String str = s.next();
//        char[] arr = str.toCharArray();
//        String[] token = str.split(" ");
//        int x =0;
//        int line = 0;
//        for (; x < arr.length;) {
//            line = line%N;
//            if (lim[line] > token[x].length()) {
//                lim[line] -= token[x].length();
//                x+=token[x].length();
//                System.out.print(token[x]);
//            }
//            else if (lims[line] != lim[line] && lim[line] < token[x].length())
//                line++;
//            else if(lims[line] == lim[line] && lim[line] < token[x].length()) {
//                token(x) =
//                lims
//            }
//        }
//    }
//}
