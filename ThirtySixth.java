    /**
     * Created by Saksham on 2016-03-05.
     */
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    public class ThirtySixth {
        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            String[] token;
            ArrayList<Integer>[] map = new ArrayList[N+1];
            int[] paths = new int[N+1];
            paths[N] = 1;
            while(true) {
                token = br.readLine().split(" ");
                int a = Integer.parseInt(token[0]);
                int b = Integer.parseInt(token[1]);
                if (a == 0) {
                    break;
                }
                if (map[a] == null) {
                    map[a] = new ArrayList<>();
                }
                paths[a]++;
                map[a].add(b);

            }
            int total = 0;
            for (int x = 1; x < N+1; x++) {
                if (map[x] != null) {
                    total += map[x].size() - 1;
                }
            }
    //        Stack<Integer> stack = new Stack<>();
    //        stack.push(N);
    //        total = 0;
    //        while(!stack.isEmpty()) {
    //            int cur = stack.pop();
    //            if (cur == 1) {
    //                total++;
    //            }
    //            if (map[cur] != null) {
    //                for (int i : map[cur]) {
    //                    stack.push(i);
    //                }
    //            }
    //        }
            System.out.println(total+1);
        }
    }