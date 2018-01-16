    /**
     * Created by Saksham on 2016-05-22.
     */

    import java.util.*;
    import java.io.*;
    class ABC {
        int a;
        int b;
        int c;
        public ABC (int A, int B, int C) {
            a = A;
            b = B;
            c = C;
        }
        @Override
        public boolean equals(Object f) {
            ABC z = (ABC)f;
            return (a == z.a && b == z.b && c == z.c);
        }
        public int hashCode() {
            int result = 0;
            result |= a;
            result <<= 5;
            result |= b;
            result <<=5;
            result |=c;
            return result;
        }
        public String toString() {
            return a + " " + b + " " + c;
        }
    }
    public class DrawDown {
        static BufferedReader br;
        static int N;
        static char[] num;
        static HashSet<ABC> set;
        static HashSet<Integer> cont;
        public static void main(String[] args) throws IOException {
            //Scanner s = new Scanner(System.in);
            br = new BufferedReader(new InputStreamReader(System.in));
            String[] token = null;
            N = rInt();
            num = br.readLine().toCharArray();
            //System.out.println(Arrays.toString(num));
            //int end = num.length - num.length%3;
            set = new HashSet<>();
            cont = new HashSet<>();
            recur(0,0,0,0);
            for (int x : cont) {
                System.out.println(x);
            }
        }
        public static void recur(int ind, int a, int b, int c) {
            int x = 0;
            if (set.contains(new ABC(a,b,c))) return;
            else set.add(new ABC(a,b,c));
            for (x = ind; x < num.length; x++) {
                if (num[x] == '1') a++;
                else if (num[x] == '2') b++;
                else if (num[x] == '3') c++;
                else {
                    int y = Math.min(a, Math.min(c,b));
                    if (a == y) {
                       recur(x + 1, a+1, b, c);
                    }
                    if (b == y) {
                       recur(x + 1, a, b+1, c);
                    }
                    if (c == y) {
                       recur(x + 1, a, b, c+1);
                    }
                    break;
                }
            }

            if (x == num.length || x == num.length-1) {
                set.add(new ABC(a,b,c));
              //  System.out.println(a + " " + b + " " + c);
                int y = Math.min(a, Math.min(c, b));
                if (a == y) {
                    cont.add(1);
                }
                if (b == y) {
                    cont.add(2);
                }
                if (c == y) {
                    cont.add(3);
                }
            }
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
