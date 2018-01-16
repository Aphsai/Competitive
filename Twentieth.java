/**
 * Created by Saksham on 2016-02-25.
 */
import java.util.*;
public class Twentieth {
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int N = s.nextInt();

    int M = s.nextInt();
    int J = s.nextInt();
    int [] arr = new int[N+1];
    for (int x =0; x < J;x++) {
        int X1 = s.nextInt();
        int X2 = s.nextInt();
        int I = s.nextInt();
        arr[X1] += I;
        arr[X2] += I;

    }
    int total = 0;
    boolean min = false;
    boolean max = false;
    for (int x = 1; x< N+1;x++) {
        if (!min && arr[x] < M) {
            total++;
        }
        else {
            min = true;
        }
        if (!max && arr[arr.length-x] < M ) {
            total++;
        }
        else {
            max = true;
        }
        if (!max && !min) {
            break;
        }

    }
    System.out.println(total);
}

}
