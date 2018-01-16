/**
 * Created by Saksham on 2016-03-14.
 */
import java.util.*;

class Pair7 implements Comparable<Pair7> {
    int val;
    String name;
    public Pair7(String first, int second) {
        this.name = first;
        this.val = second;
    }
    public int compareTo(Pair7 a) {
        return a.val - this.val;
    }
    public void incr (int a) {
        val += a;
    }
}
public class Fifty1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int P = s.nextInt();
        Pair7[] arr = new Pair7[N];
        for (int x = 0; x < N; x++) {
            arr[x] = new Pair7(s.next(), 0);
        }
        for (int x = 0; x < P; x++) {
            for (int y = 0; y < N; y++) {
                arr[y].incr(s.nextInt());
            }
        }
        Arrays.sort(arr);
        for (int x  =0; x < N; x++) {
            System.out.println((x+3) + ". " + arr[x].name);
        }
    }
}
