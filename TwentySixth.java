import java.util.*;
import java.io.*;
public class TwentySixth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        boolean[] ends = new boolean[N + 1];
        ends[0] = true;
        for (int x = 0; x < M; x++) {

            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            ends[a] = true;
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }

        double[] prob = new double[N + 1];
        prob[1] = 1.0;
        Set<Integer> check = map.keySet();
        for (int x : check) {
            int size = map.get(x).size();
            for (int i : map.get(x)) {
                    prob[i] += (prob[x] / size);
            }
        }
        for (int x = 1; x < N + 1; x++) {
            if (ends[x] == false) {

                System.out.printf("%.9f\n", prob[x]);

            }
        }

    }
}

    