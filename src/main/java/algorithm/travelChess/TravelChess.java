package algorithm.travelChess;

/**
 * @author renzhiyong
 * @description:马踏棋盘 --- 回溯法  未验证
 * @date 2018-05-16 23:31
 */
public class TravelChess {
    //棋盘大小
    int size = 5;
    //初始棋盘
    int[][] chess = new int[size][size];
    //解的个数
    int total;

    public void travel(int x, int y) {
        nextStep(chess, x, y, 1);
    }

    private void nextStep(int[][] chess, int x, int y, int step) {
        chess[x][y] = step;

        if (size*size == step) {
            total++;
            System.out.println("============"+total+"===============");
            printChess(chess);
            return;
        }

        int[][] temp = copy(chess);

        if (x-2>=0 && y-1>=0 && temp[x-2][y-1] == 0) {
            nextStep(temp, x-2, y-1, step+1);
        }

        if (x-1>=0 && y-2>=0 && temp[x-1][y-2] == 0) {
            nextStep(temp, x-1, y-2, step+1);
        }

        if (x+1<size && y-2>=0 && temp[x+1][y-2] == 0) {
            nextStep(temp, x+1, y-2, step+1);
        }

        if (x+2<size && y-1>=0 && temp[x+2][y-1] == 0) {
            nextStep(temp, x+2, y-1, step+1);
        }

        if (x+2<size && y+1<size && temp[x+2][y+1] == 0) {
            nextStep(temp, x+2, y+1, step+1);
        }

        if (x+1<size && y+2<size && temp[x+1][y+2] == 0) {
            nextStep(temp, x+1, y+2, step+1);
        }

        if (x-1>=0 && y+2<size && temp[x-1][y+2] == 0) {
            nextStep(temp, x-1, y+2, step+1);
        }

        if (x-2>=0 && y+1<size && temp[x-2][y+1] == 0) {
            nextStep(temp, x-2, y+1, step+1);
        }

    }

    private void printChess(int[][] chess) {
        for (int[] ints : chess) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private int[][] copy(int[][] chess) {
        int[][] temp = new int[size][size];
        for (int i = 0; i < chess.length; i++) {
            System.arraycopy(chess[i], 0, temp[i], 0, size);
        }

        return temp;
    }

    public static void main(String[] args) {
        TravelChess travelChess = new TravelChess();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(String.format("+++++++++++++++++++++(%s,%s)+++++++++++++++++++++", i, j));
                travelChess.travel(i, j);
            }
        }



    }
}
