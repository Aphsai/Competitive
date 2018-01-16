import java.util.*;

public class Seventeenth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = 0;
        int N = s.nextInt();
        int W = s.nextInt();
        if (W !=0) {
            int H = s.nextInt();
            for (int x =1; x < W; x++) {
                total += N;
            }
            for (int x = W-1; x < 6; x++) {
                total += N + H;
            }
        }
        else
            total = N*6;

        System.out.println("It takes " + total + " hours for Team 610 build a robot.");
    }
}