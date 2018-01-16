/**
 * Created by Saksham on 2016-02-20.
 */
import java.util.*;
public class Fourtheenth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int x =0 ;x < T; x++) {
            int N = s.nextInt();

            Stack<Integer> q = new Stack<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            for (int y =0; y < N; y++) {
                q.add(s.nextInt());
                System.out.println(q.peek());
            }
            int ing = 1;
            while(!q.isEmpty() || !stack.isEmpty()) {
                if (!q.isEmpty() && q.peek() == ing) {
                     System.out.println("QUEUE: " + q.peek());
                       System.out.println("IN");
                    q.pop();
                    ing++;
                } else if (!stack.isEmpty() && stack.peek() == ing) {
                     System.out.println("STACK: " + stack.peek());
                    ing++;
                    stack.pop();

                }
                else if(q.isEmpty() && !stack.isEmpty() && stack.peek() != ing) {
                    System.out.println("N");
                    return;
                }
                else {
                     System.out.println("ADDED");
                    stack.add(q.pop());
                }
            }
                System.out.println("Y");

        }
    }
}
