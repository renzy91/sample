package algorithm.queen;

import java.util.Arrays;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-07 10:37
 */
public class Queen {
//    public static final int n = 8;
    public static int total = 0;
//    public static final int[] t = new int[n];

    public static void main(String[] args) {
        int[] t = new int[4];
        queen(t, 0);
    }

    public static void queen(int[] tab, int row) {
        if (row == tab.length) {
            total++;
            System.out.println(total + "######################################");
            printTab(tab);
//            System.out.println("#########################################");
            return;
        }

        int[] temp = new int[tab.length];
        System.arraycopy(tab, 0, temp, 0, tab.length);

        for (int col = 0; col < temp.length; col++) {
            temp[row] = col;
            if (isOk(temp, row)) {
                queen(temp, row+1);
            }
        }
        
    }

    private static void printTab(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i]);
        }
        System.out.println();
    }

    private static boolean isOk(int[] tab, int row) {
        for (int i = 0; i < row; i++) {
            if (tab[i] == tab[row] || i + tab[i] == row + tab[row] || i - tab[i] == row - tab[row]) {
                return false;
            }
        }
        return true;
    }

}
