
    import java.util.*;
    import java.io.*;
    public class BusJam {
        static BufferedReader br;
        public static void main(String[] args) throws IOException{
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] token = br.readLine().split(" ");
            int N = Integer.parseInt(token[0]);
            int M = Integer.parseInt(token[1]);
            int H = Integer.parseInt(token[2]);
            int[] time = new int[N];
            for (int x = 0;x  < N; x++) {
                time[x] = Integer.parseInt(br.readLine());
            }
            int breaks = 0;
            for (int x = 1; x < N; x++) {
                int dif = time[N-x] - time[N-x-1];
                //   System.out.print(time[N-x] + " " + time[N-x-1]+ " " + dif);
                if (dif > H) {
                    int tim = (int)Math.ceil((dif - H)/(double)M);
                   // System.out.print(" " + tim);
                    breaks += tim;
                    time[N-x-1] += tim*M;
                }
               //  System.out.println();
            }
            System.out.println(breaks);
        }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static String[] split(String s) {
        return s.split(" ");
    }

    static String[] read() throws IOException {
        return split(br.readLine());
    }

    static int rInt() throws IOException {
        return toInt(br.readLine());
    }

    static int[] rIntAr() throws IOException {
        String[] temp = read();
        int[] t = new int[temp.length];
        for (int x = 0; x < temp.length; x++) {
            t[x] = toInt(temp[x]);
        }
        return t;
    }
}
