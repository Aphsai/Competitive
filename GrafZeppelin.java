/**
 * Created by Saksham on 2016-03-17.
 */
import java.util.*;
public class GrafZeppelin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int[] cache = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int x =0; x < M; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (arr[a] == null){
                arr[a] = new ArrayList<>();
            }
            if (arr[b] == null) {
                arr[b] = new ArrayList<>();
            }
            arr[a].add(b);
            arr[b].add(a);
        }
    }
}
