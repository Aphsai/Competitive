/**
 * Created by Saksham on 2016-03-16.
 */
import java.util.*;
public class ChancesOfWinning {
    static int[][] played;
    static int T;
    static int W;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int G = s.nextInt();
        played = new int[7][7];
        for (int x =0; x < 7; x++) {
            Arrays.fill(played[x],-1);
        }
        for (int x =0; x < G; x++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int Sa = s.nextInt();
            int Sb = s.nextInt();
            if (Sa > Sb) {
                played[a][b] = 3;
                played[b][a] = 0;
            }
            else if (Sb > Sa) {
                played[b][a] = 3;
                played[a][b] = 0;
            }
            else {
                played[a][b] = 1;
                played[b][a] = 1;
            }
        }
    }
    static int recurse (int N) {

return 0;
    }
}
