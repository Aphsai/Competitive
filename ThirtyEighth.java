/**
 * Created by Saksham on 2016-03-05.
 */
import java.util.*;
public class ThirtyEighth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] fr = new int[10000];
        for (int x = 0; x < N; x++) {
            fr[s.nextInt()] = s.nextInt();
        }
        while(true) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (a == 0){
                break;
            }
            int counter = 0;
            int ind = a;
            int val = fr[ind];
            boolean[] visited = new boolean[10000];
            boolean incr = false;
            ArrayList<Integer> rel = new ArrayList<>();
            while(true) {
//                System.out.println("IND " + ind + " VAL " + fr[ind]);
                rel.add(val);
                if (visited[ind] == true) {
                    counter = rel.indexOf(b);
                    if (counter == -1) {
                        System.out.println("No");
                    }
                    else
                        System.out.println("Yes " + counter);
                    break;

                }
                if (ind == 0){
                    System.out.println("No");
                    break;
                }
                visited[ind] = true;
                ind = fr[ind];
                val = fr[ind];
            }
        }
    }
}
