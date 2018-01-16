import java.util.*;
import java.io.*;
public class ThirtyThird {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        Stack<Integer>[] map = new Stack[N+1];
        for (int x = 0; x < M; x++) {

            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            if (map[a] == null) {
                map[a] = new Stack<Integer>();
            }
            map[a].push(b);
        }

        double[] prob = new double[N + 1];
        prob[1] = 1.0;
        for (int x = 1; x < N+1; x++) {
            if (map[x] != null) {
                int size = map[x].size();
                for (int i = 0; i < map[x].size(); i++) {
                    int w = map[x].get(i);
                    prob[w] += prob[x]/size;
                }
            }
            else {
                System.out.printf("%.9f\n", prob[x]);
            }
        }

    }
}