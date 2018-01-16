    /**
     * Created by Saksham on 2016-03-20.
     */

    import java.util.*;
    import java.io.*;
    class AlphaKey implements Comparable<AlphaKey>{
        char x;
        int amount;
        public AlphaKey(char a, int am) {
            x = a;
            amount = am;
        }
        public void incr() {
            amount++;
        }
        public void decr() {
            amount--;
        }
        public int compareTo(AlphaKey a) {
            if (a.amount == amount) {
                return x - a.x;
            }
            return a.amount - amount;
        }
    }
    public class RollingEncryption {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
            HashMap<Character, AlphaKey> accord = new HashMap<Character, AlphaKey>();
            ArrayList<AlphaKey> set = new ArrayList<>();
            for (int x =0; x < 26; x++) {
                accord.put((char)('a' + x), new AlphaKey((char)('a' + x), 0));
                set.add(accord.get((char)('a'+x)));
            }

            int K = Integer.parseInt(br.readLine());
            char[] original = br.readLine().toCharArray();
            char[] altered = new char[original.length];

            for (int x =0; x < K; x++) {
                accord.get(original[x]).incr();
                altered[x] = original[x];
            }
            int LP = 0;
            int RP = K;
            for (int x = K; x < altered.length; x++) {
                //System.out.println(map.lastEntry().getKey() + " " + map.lastEntry().getValue());
                Collections.sort(set);
                //System.out.println(set.get(0).x + " " + set.get(0).amount);
                altered[x] = (char)(97 + ((original[x]-97) + (set.get(0).x-96))%26);
                accord.get(original[LP]).decr();
                accord.get(original[x]).incr();
                LP++;
            }
            for (int x =0; x < original.length; x++) {
                System.out.print(altered[x]);
            }
    //abbaacdcdegdgh
        }
    }
