/**
 * Created by Saksham on 2016-05-24.
 */

import java.util.*;
import java.io.*;
class TrieNodeA {
    HashMap<Character, TrieNodeA> map = new HashMap<>();
}

/* Suse
* import java.io.*;
import java.util.*;
public class CCC03S4 {
  public static void main(String[]args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    String temp;

    for (int i = 0; i < n; i++) {
      temp = in.readLine();
      String[]a = new String[temp.length()];
      for (int x = 0; x < temp.length(); x++) {
        a[x] = temp.substring(x);
      }

      Arrays.sort(a);

      int result = 0;

      result = a[0].length();

      for (int x = 1; x < a.length; x++) {
        result += a[x].length() - lcp(a[x - 1], a[x]);
      }

      System.out.println(result + 1);
    }
  }

  public static int lcp(String a, String b) {
    int count = 0;
    if (a.length() <= b.length()) {
      for (int x = 0; x < a.length(); x++) {
        if (a.charAt(x) == b.charAt(x))
              count++;
        else
              return count;
      }
    }
    else {
      for (int x = 0; x < b.length(); x++) {
        if (a.charAt(x) == b.charAt(x))
              count++;
        else
              return count;
      }
    }
    return count;
  }
}*/
public class Substrings {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = rInt();
        for (int z = 0; z < N; z++) {
            TrieNodeA root = new TrieNodeA();
            char[] str = br.readLine().toCharArray();
            int total = 0;
            for (int x = 0; x < str.length; x++) {
                TrieNodeA temp = new TrieNodeA();
                temp = root;
                for (int y = x; y < str.length; y++) {
                    if (temp.map.containsKey(str[y])) {
                        temp = temp.map.get(str[y]);
                    }
                    else {
                        temp.map.put(str[y], new TrieNodeA());
                        total++;
                        temp = temp.map.get(str[y]);
                    }
                }
            }
            System.out.println(total+1);
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
