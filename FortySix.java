import java.util.*;

public class FortySix {
    static String[] names;
    static int [][][] cache;
    static int [] checked, val, wei, cost;

    static int bfs(int n, int r, int s) {
        if (r < 0 || s < 0 || n == 0) return 0;
        if (cache[n][r][s] != 0) return cache[n][r][s];
        if (cost[n - 1] > r || wei[n - 1] > s) return cache[n][r][s] = bfs(n-1, r, s);
        else return cache[n][r][s] = Math.max(val[n - 1] + bfs(n, r - cost[n - 1], s - wei[n - 1]), bfs(n - 1, r, s));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int R = s.nextInt();
        int S = s.nextInt();
        checked = new int[N];
        cache = new int[N+1][R+1][S+1];
        names = new String[N];
        val = new int[N];
        wei = new int[N];
        cost = new int[N];

        for (int x = 0; x < N; x++) {
            names[x] = s.next();
            val[x] = s.nextInt();
            cost[x] = s.nextInt();
            wei[x] = s.nextInt();
        }

        System.out.println(bfs(N,R,S));

        int r = R, so = S, x = N;
        for (; x > 0;) {
            if (r - cost[x-1] < 0 || so - wei[x-1] < 0 || cache[x][r][so] - cache[x][r-cost[x-1]][so-wei[x-1]] != val[x-1]) x--;
            else {
                checked[x - 1]++;
                r -= cost[x - 1];
                so -= wei[x - 1];
            }
        }
        for (int n = 0; n < N; n++) {
            System.out.println(names[n] + " " + checked[n]);
        }
    }
}
