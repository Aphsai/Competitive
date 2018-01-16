import java.util.*;

public class Eighteenth  {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int total = N;
        while (true){
            int rem = N%K;
            N = (N - rem) /  K + rem;
            total += N;
            System.out.println("REM: " + rem + " N: " + N);
            if (N < K) {
                System.out.println(total);
                return;
            }
        }
    }
}