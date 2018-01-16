/**
 * Created by Saksham on 2016-06-02.
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
class WALLS {
    int x;
    int y;
    int pX;
    int pY;
    public WALLS(int X, int Y, int PX, int PY) {
        x = X;
        y = Y;
        pX = PX;
        pY = PY;
    }
}
public class DungeonGeneration extends JPanel {
    Graphics g;
    static final int WIDTH = 5;
    static final int HEIGHT = 5;
    static final int MAPWIDTH = 50;
    static final int MAPHEIGHT = 50;
    static int [][] map = new int[MAPWIDTH][MAPHEIGHT];
    static final int BOUNDS = 20;
    static final int LOWERBOUNDS = 8;
    Random r = new Random();
    public DungeonGeneration() throws IOException {
        super();
        setVisible(true);
        setPreferredSize(new Dimension(500, 500));
        setFocusable(true);
        requestFocus();
        ArrayList<int[]> dungeons = new ArrayList<>();
        for (int  i = 0; i < 20; i++) {
            int width = LOWERBOUNDS +  r.nextInt(BOUNDS);
            int height = LOWERBOUNDS + r.nextInt(BOUNDS);
            int W = r.nextInt(MAPWIDTH - (width));
            int H = r.nextInt(MAPHEIGHT - (height));
            if (W < 4 || H < 4) {
                i--;
                continue;
            }
            boolean check = false;
            for (int x = W; x < W + width; x++) {
                for (int y = H; y < H + height; y++) {
                    if (map[x][y] != 0) {check = true; break;}
                }
            }
            if (!check) {
                dungeons.add(new int[]{W, H, W+width, H+height});
            for (int x = W; x < W + width; x++) {
                for (int y = H; y < H + height; y++) {
                    map[x][y] = 1;
                    if (x == W || x == W + width - 1 || y == H || y == H + height - 1)
                    map[x][y] = 2;
                }
            }
            }
        }
        LinkedList<WALLS> q = new LinkedList<>();
        q.add(new WALLS(1,1,1,1));
        while(q.size() != 0) {
            WALLS index = q.remove(r.nextInt(q.size()));
            int x = index.pX;
            int y = index.pY;
            if (map[x][y] == 0) {
                map[index.x][index.y] = 1;
               // if (map[x][y] != 2)
                map[index.pX][index.pY] = 1;
                if (valid(x + 2, y)) q.add(new WALLS(x + 1, y, x + 2, y));
                if (valid(x - 2, y)) q.add(new WALLS(x - 1, y, x - 2, y));
                if (valid(x, y + 2)) q.add(new WALLS(x, y + 1, x, y + 2));
                if (valid(x, y - 2)) q.add(new WALLS(x, y - 1, x, y - 2));
            }
        }
        for (int[] x: dungeons) {
            int W = x[0];
            int H = x[1];
            int RB = x[2];
            int LB = x[3];
            while(true) {
              if (map[W][H+1] == 1) break;
              else map[W][H+1] = 1;
                W--;
            }
            while(true) {
                if (map[RB-1][LB-2] == 1) break;
                else map[RB-1][LB-2] = 1;
                RB++;
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("/Maps/map1-1.map"));
        pw.println(MAPWIDTH);
        pw.println(MAPHEIGHT);
        for (int x =0 ; x < MAPHEIGHT; x++) {
            for (int y = 0; y < MAPWIDTH; y++) {
                pw.print(map[x][y]);
            }
            pw.println();
        }
        pw.close();
//      DEBUGGING
//        for (int x = 0; x < MAPHEIGHT; x++) {
//            for (int y = 0; y < MAPWIDTH; y++) {
//                if (map[x][y]== 1) System.out.print("X");
//                else System.out.print("O");
//            }
//            System.out.println();
//
        repaint();
    }
    public static boolean valid(int x, int y) {
        return (x < MAPWIDTH && x > 0 && y < MAPHEIGHT && y > 0 && map[x][y] != 1);
    }
    public void paint(Graphics g) {
        for (int x = 0; x < MAPWIDTH; x++) {
            for (int y = 0; y < MAPHEIGHT; y++) {
                if (map[x][y] == 1) {g.fillRect(x * WIDTH, y * WIDTH, WIDTH, WIDTH);}

            }
        }
    }

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        window.setVisible(true);
        //window.setPreferredSize(new Dimension(500,500));
        window.setContentPane(new DungeonGeneration());
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
