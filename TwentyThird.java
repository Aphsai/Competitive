/**
 * Created by Saksham on 2016-02-28.
 */
import java.util.*;
public class TwentyThird {
    public static void main(String[] args) {
        Scanner s=  new Scanner(System.in);
        int R = s.nextInt();
        int C = s.nextInt();
        int [][] mouse = new int[R][C];

        int Q = s.nextInt();
        for (int x = 0; x < Q;x++) {
            mouse[s.nextInt()-1][s.nextInt()-1] = -1;
        }
        for (int x = 0; x < R; x++) {
            if (mouse[x][0] == -1) {
                break;
            }
            mouse[x][0] = 1;
        }
        for (int x = 0; x < C; x++) {
            if (mouse[0][x] == -1) {
                break;
            }
            mouse[0][x] = 1;
        }
        for (int x = 1; x < R; x++) {
            for (int y = 1; y < C; y++) {
                if (mouse[x][y] == 0) {
                    if (mouse[x - 1][y] > 0) {
                        mouse[x][y] += mouse[x - 1][y];
                    }
                    if (mouse[x][y - 1] > 0) {
                        mouse[x][y] += mouse[x][y - 1];
                    }
                }

            }
        }
        System.out.println(mouse[R-1][C-1]);

    }

}
