/**
 * Created by Saksham on 2016-02-25.
 */
import java.util.*;

public class Nineteenth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        ArrayDeque<Integer> arr= new ArrayDeque<Integer>();
        int served = 0;
        int late = 0;
        while(true) {
            String check = s.next();
            if (check.equals("EOF")) {
                break;
            }
            if (check.equals("TAKE")) {
                late++;
                N++;
                if (N == 1000)
                    N = 1;
                arr.addLast(N);
            }
            else if (check.equals("SERVE")) {
                if (!arr.isEmpty()) arr.removeFirst();
            }
            else {
                System.out.println(late + " " + arr.size() + " " + N);
                served = 0;
                late = 0;
                arr= new ArrayDeque<Integer>();
            }


        }
    }
}
