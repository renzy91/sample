package algorithm.gcd;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-26 11:44
 */
public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcd(6, 12));
    }

    /**
     * 辗转法求最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        int max = a > b ? a : b;
        int min = a> b ? b : a;

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
