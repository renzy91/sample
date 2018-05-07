package algorithm.hanoi;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-06 23:20
 */
public class Hanoi {
    public static void main(String[] args) {
        move(4, "x", "y", "z");

    }

    //将n个 从x借助y移动至z
    public static void move(int n, String x, String y, String z) {
        if (n == 1) {
            System.out.println(String.format("%s --> %s", x, z));
            return;
        }
        //1.将前n-1个从x借助z移动至y
        move(n-1, x, z, y);
        //2.将第n个从x移动至z
        System.out.println(String.format("%s --> %s", x, z));
        //3.将n-1个从y借助x移动至z
        move(n-1, y, x, z);
    }
}
